package fr.xamez.aventuriersrail.vues;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * Cette classe correspond à une nouvelle fenêtre permettant de choisir le nombre et les noms des joueurs de la partie.
 *
 * Sa présentation graphique peut automatiquement être actualisée chaque fois que le nombre de joueurs change.
 * Lorsque l'utilisateur a fini de saisir les noms de joueurs, il demandera à démarrer la partie.
 */
public class VueChoixJoueurs extends Stage {

    private static final int MAX_JOUEURS = 5;
    private static final int MIN_JOUEURS = 2;

    private final ObservableList<String> nomsJoueurs;

    private final Label title;

    private VBox joueurs;

    private final Button commencerPartie;

    public List<String> getNomsJoueurs() {
        return nomsJoueurs;
    }

    public VueChoixJoueurs() {
        nomsJoueurs = FXCollections.observableArrayList();

        title = new Label("Ajout des joueurs");
        title.setStyle("-fx-font-size: 28px; -fx-font-weight: bold;");

        joueurs = new VBox();
        joueurs.setPrefHeight(200);
        joueurs.setSpacing(5);
        for (int i = 0; i < MIN_JOUEURS; i++)
           ajoutJoueur();

        StackPane stackPane = new StackPane();

        VBox hBox = new VBox();
        VBox.setMargin(title, new Insets(20, 0, 0, 0));
        hBox.setAlignment(Pos.TOP_CENTER);
        hBox.setSpacing(30);

        commencerPartie = new Button("Commencer la partie");
        commencerPartie.setStyle("-fx-background-color: #e0c9b1; -fx-background-radius: 15; -fx-font-size: 22px; -fx-font-weight: bold;");

        ImageView backgroundView = new ImageView(getClass().getClassLoader().getResource("images/backgrounds/bg-select-player-names.jpg").toString());
        backgroundView.setEffect(new GaussianBlur(6));

        hBox.getChildren().addAll(title, joueurs, commencerPartie);
        stackPane.getChildren().addAll(hBox, backgroundView);

        backgroundView.toBack();
        hBox.toFront();

        Scene scene = new Scene(stackPane, backgroundView.getImage().getWidth(), backgroundView.getImage().getHeight());
        setScene(scene);
        setTitle("Rails - Choix des joueurs");
        setResizable(false);
        centerOnScreen();
    }

    private BiConsumer<Integer, Boolean> toggleButtonConsumer = (index, isVisible) -> {
        for (Node node : joueurs.getChildren()) {
            HBox hBox2 = (HBox) node;
            hBox2.getChildren().get(index).setVisible(isVisible);
        }
    };

    private void ajoutJoueur() {
        HBox hBox = new HBox();
        hBox.setId(Integer.toString(nomsJoueurs.size()));
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        TextField nomJoueur = new TextField("Joueur " + (nomsJoueurs.size() + 1));
        nomJoueur.setStyle("-fx-background-color: #f1e9da; -fx-background-radius: 15; -fx-font-size: 14px;");
        nomJoueur.textProperty().addListener((observable, oldValue, newValue) -> nomsJoueurs.set(nomsJoueurs.indexOf(oldValue), newValue));

        Button ajouterJoueur = new Button("+");
        ajouterJoueur.setStyle("-fx-background-color: #3fff00; -fx-background-radius: 20; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold;");
        ajouterJoueur.setPadding(new Insets(4, 10, 4, 10));
        ajouterJoueur.setOnAction(e -> ajoutJoueur());

        Button supprimerJoueur = new Button("-"); // f1e9da
        supprimerJoueur.setStyle("-fx-background-color: #ff4040; -fx-background-radius: 20; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold;");
        supprimerJoueur.setPadding(new Insets(3, 10, 4, 10));
        supprimerJoueur.setOnAction(e -> supprimerJoueur(nomJoueur));

        hBox.getChildren().addAll(nomJoueur, ajouterJoueur, supprimerJoueur);
        joueurs.getChildren().add(hBox);
        nomsJoueurs.add(nomJoueur.getText());

        if (nomsJoueurs.size() > 1) {
            HBox childrenHbox = (HBox) joueurs.getChildren().get(joueurs.getChildren().size() - 2); // on prends la précédente ligne et on masque le bouton +
            childrenHbox.getChildren().get(1).setVisible(false);
        }

        if (nomsJoueurs.size() == MAX_JOUEURS)
            ajouterJoueur.setVisible(false);

        if (nomsJoueurs.size() == MIN_JOUEURS)
            toggleButtonConsumer.accept(2, false);

        if (nomsJoueurs.size() > MIN_JOUEURS)
            toggleButtonConsumer.accept(2, true);
    }

    private void supprimerJoueur(TextField textField) {
        nomsJoueurs.remove(textField.getText());
        joueurs.getChildren().remove(textField.getParent());

        if (nomsJoueurs.size() == MIN_JOUEURS)
            toggleButtonConsumer.accept(2, false);

        if (nomsJoueurs.size() < MAX_JOUEURS) {
            HBox childrenHbox = (HBox) joueurs.getChildren().get(joueurs.getChildren().size() - 1);
            childrenHbox.getChildren().get(1).setVisible(true);
        }

    }

    /**
     * Définit l'action à exécuter lorsque la liste des participants est correctement initialisée
     */
    public void setNomsDesJoueursDefinisListener(ListChangeListener<String> quandLesNomsDesJoueursSontDefinis) {
        commencerPartie.setOnAction(event -> {
            for (int i = 0; i < nomsJoueurs.size(); i++)
                if (nomsJoueurs.get(i).equals(""))
                    nomsJoueurs.set(i, "Joueur " + (i + 1));
            quandLesNomsDesJoueursSontDefinis.onChanged(null);
            close();
        });
    }

    /**
     * Retourne le nombre de participants à la partie que l'utilisateur a renseigné
     */
    protected int getNombreDeJoueurs() {
        return nomsJoueurs.size();
    }

}
