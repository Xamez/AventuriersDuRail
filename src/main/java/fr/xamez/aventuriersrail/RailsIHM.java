package fr.xamez.aventuriersrail;

import fr.xamez.aventuriersrail.rails.ServiceDuJeu;
import fr.xamez.aventuriersrail.vues.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.collections.ListChangeListener;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class RailsIHM extends Application {

    private VueFenetreDemarrage vueFenetreDemarrage;
    private VueChoixJoueurs vueChoixJoueurs;
    private VueFinDuJeu vueFinDuJeu;
    private Stage primaryStage;
    private ServiceDuJeu serviceDuJeu;

    private boolean avecVueChoixJoueurs = true;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        vueFenetreDemarrage = new VueFenetreDemarrage();
        vueFenetreDemarrage.setActionQuandRegleCliquer(() -> {
            getHostServices().showDocument(getClass().getClassLoader().getResource("Les Aventuriers du Rail - Règles.pdf").toString());
        });
        vueFenetreDemarrage.setActionQuandJouerCliquer(() -> {
            vueFenetreDemarrage.close();
            lancerPartie();
        });
        vueFenetreDemarrage.setActionQuandControlesCliquer(() -> {
            vueFenetreDemarrage.close();
            demarrerControles();
        });
        vueFenetreDemarrage.show();
    }

    private void lancerPartie() {
        if (avecVueChoixJoueurs) {
            vueChoixJoueurs = new VueChoixJoueurs();
            vueChoixJoueurs.setOnCloseRequest(e -> {
                vueChoixJoueurs.close();
                vueFenetreDemarrage.show();
            });
            vueChoixJoueurs.setNomsDesJoueursDefinisListener(quandLesNomsJoueursSontDefinis);
            vueChoixJoueurs.show();
        } else {
            Platform.runLater(this::demarrerPartie);
        }
    }

    private void demarrerControles() {
        VueFenetreControles vueFenetreControles = new VueFenetreControles();
        vueFenetreControles.setActionSurDerniereFleche(() -> {
            vueFenetreDemarrage.show();
            vueFenetreControles.close();
        });
        vueFenetreControles.setOnCloseRequest(e -> {
            vueFenetreDemarrage.show();
            vueFenetreControles.close();
        });
        vueFenetreControles.show();
    }

    private void demarrerPartie() {
        serviceDuJeu = new ServiceDuJeu(vueChoixJoueurs.getNomsJoueurs().toArray(String[]::new));
        VueMain vueMain = new VueMain(serviceDuJeu.getJeu());
        Scene scene = new Scene(vueMain); // la scene doit être créée avant de mettre en place les bindings
        vueMain.creerBindings();
        demarrerServiceJeu(); // le service doit être démarré après que les bindings ont été mis en place

        serviceDuJeu.getJeu().instructionProperty().addListener(quandInstructionChange);

        vueFinDuJeu = new VueFinDuJeu(serviceDuJeu.getJeu());

        String[] stylesheets = new String[]{"vueMain", "vuePlateau", "vueDuJeu", "vueCarteDestinationJoueurCourant"};
        for (String stylesheet : stylesheets) scene.getStylesheets().add("css/" + stylesheet + ".css");

        primaryStage.setScene(scene);
        primaryStage.setTitle("Rails");
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.setWidth(1100);
        primaryStage.setHeight(770);
        primaryStage.setOnCloseRequest(event -> {
            this.onStopGame();
            event.consume();
        });
        primaryStage.show();
    }

    private void demarrerServiceJeu() {
        if (serviceDuJeu.getState() == Worker.State.READY)
            serviceDuJeu.start();
    }

    private final ChangeListener<String> quandInstructionChange = (observableValue, ancienTexte, nouveauTexte) -> {
        if (nouveauTexte.equals("Fin de la partie.")) {
            primaryStage.close();
            vueFinDuJeu.show();
        }
    };

    private final ListChangeListener<String> quandLesNomsJoueursSontDefinis = change -> {
        if (!vueChoixJoueurs.getNomsJoueurs().isEmpty())
            demarrerPartie();
    };

    private void onStopGame() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setContentText("On arrête de jouer ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            serviceDuJeu.getJeu().cancel();
            Platform.exit();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}