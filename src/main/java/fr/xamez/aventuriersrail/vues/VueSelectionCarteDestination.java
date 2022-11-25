package fr.xamez.aventuriersrail.vues;

import fr.xamez.aventuriersrail.IJeu;
import fr.xamez.aventuriersrail.rails.Destination;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class VueSelectionCarteDestination extends VBox {

    private final IJeu jeu;
    private final HBox destinations;
    private final Button passer;

    public VueSelectionCarteDestination(IJeu jeu) {
        this.jeu = jeu;
        destinations = new HBox();
        destinations.setSpacing(20);
        destinations.setAlignment(Pos.CENTER);
        passer = new Button("Passer");
        passer.setStyle("-fx-background-color: #e0c9b1;");
        setSpacing(50);
        setAlignment(Pos.CENTER);
        BackgroundFill backgroundFill = new BackgroundFill(Color.rgb(0, 0, 0, 0.5), null, null);
        setBackground(new Background(backgroundFill));
        getChildren().addAll(destinations, passer);
    }

    public void checkDoitEtreFermer() {
        if (jeu.destinationsInitialesProperty().isEmpty())
            ((VueMain) getScene().getRoot()).enableMainVue();
    }

    public void creerBindings() {
        passer.setOnAction(event -> jeu.passerAEteChoisi());
        ListChangeListener<Destination> destinationListChangeListener = change -> {
            Platform.runLater(() -> {
                while (change.next()) {
                    if (!change.getList().isEmpty()) {
                        change.getAddedSubList().forEach(destination -> {
                            VueDestination vueCarteDestination = new VueDestination(destination, true);
                            vueCarteDestination.setOnMouseClicked(e -> {
                                FadeTransition fadeTransition = new FadeTransition(new Duration(200), vueCarteDestination);
                                fadeTransition.setToValue(0);
                                fadeTransition.play();
                                fadeTransition.setOnFinished(e2 -> {
                                    destinations.getChildren().remove(vueCarteDestination);
                                    jeu.uneDestinationAEteChoisie(destination.getNom());
                                });
                            });
                            destinations.getChildren().add(vueCarteDestination);
                        });
                    } else {
                        ((VueMain) getScene().getRoot()).enableMainVue();
                    }
                }
            });
        };
        jeu.joueurCourantProperty().addListener(e -> Platform.runLater(() -> destinations.getChildren().clear()));
        jeu.destinationsInitialesProperty().addListener(destinationListChangeListener);
    }

}
