package fr.xamez.aventuriersrail.vues;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import static fr.xamez.aventuriersrail.vues.VueDuJeu.*;

public class VueCarteProfileJoueur extends HBox {

    private Label nomJoueur;
    private Label nbGareJoueur;
    private Label nbScoreJoueur;
    private Label nbWagonsJoueur;
    private ImageView nbGaresView;
    private ImageView nbWagonsView;
    private ImageView avatarView;
    private ImageView cardView;

    public VueCarteProfileJoueur() {
        setPadding(new Insets(25, 0, 0, 25));
        setSpacing(15);
        creerIconJoueur();
        creerCarteProfileJoueur();
    }

    public void creerBindings() {
        ((VueMain) getScene().getRoot()).getJeu().joueurCourantProperty().addListener((observableValue, ancienJoueur, nouveauJoueur) -> Platform.runLater(() -> {
            avatarView.setImage(IMAGES_JOUEURS.get(nouveauJoueur));
            nomJoueur.setText(nouveauJoueur.getNom());
            nbGaresView.setImage(IMAGES_GARES.get(nouveauJoueur));
            nbGareJoueur.setText(String.valueOf(nouveauJoueur.getNbGares()));
            nbWagonsView.setImage(IMAGES_WAGONS.get(nouveauJoueur));
            nbWagonsJoueur.setText(String.valueOf(nouveauJoueur.getNbWagons()));
            nbScoreJoueur.setText("Score: " + nouveauJoueur.getScore());
        }));
    }

    private void creerIconJoueur() {
        VBox vBox = new VBox();
        vBox.setPrefWidth(80);
        avatarView = new ImageView();
        avatarView.setFitWidth(50);
        avatarView.setPreserveRatio(true);
        vBox.getChildren().add(avatarView);
        nomJoueur = new Label();
        nomJoueur.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        vBox.getChildren().add(nomJoueur);
        vBox.setAlignment(Pos.CENTER);
        vBox.setTranslateY(-10);
        getChildren().add(vBox);
    }

    private void creerCarteProfileJoueur() {
        Image card = new Image(getClass().getClassLoader().getResource("images/player/border-profile.png").toString());
        Image orb = new Image(getClass().getClassLoader().getResource("images/player/orb.png").toString());
        ImageView orbView = new ImageView(orb);
        orbView.setEffect(new Glow(3));
        orbView.setFitHeight(25);
        orbView.setTranslateX(-2);
        orbView.setTranslateY(103);
        orbView.setPreserveRatio(true);
        cardView = new ImageView(card);
        cardView.setFitWidth(90);
        cardView.setPreserveRatio(true);
        cardView.setTranslateY(-20);
        getChildren().add(cardView);

        nbScoreJoueur = new Label();
        nbScoreJoueur.setPadding(new Insets(0, 0, 5, 0));

        nbGaresView = new ImageView();
        nbGaresView.setFitWidth(25);
        nbGaresView.setPreserveRatio(true);
        nbGareJoueur = new Label();
        HBox gares = new HBox();
        gares.setSpacing(5);
        gares.setAlignment(Pos.CENTER);
        gares.getChildren().addAll(nbGaresView, nbGareJoueur);

        nbWagonsView = new ImageView();
        nbWagonsView.setFitHeight(30);
        nbWagonsView.setPreserveRatio(true);
        nbWagonsJoueur = new Label();
        HBox wagons = new HBox();
        wagons.setSpacing(5);
        wagons.setAlignment(Pos.CENTER);
        wagons.getChildren().addAll(nbWagonsView, nbWagonsJoueur);

        StackPane stackPane = new StackPane();
        VBox vBox = new VBox();
        vBox.getChildren().addAll(nbScoreJoueur, gares, wagons);
        vBox.setTranslateY(-17);
        vBox.setAlignment(Pos.CENTER);
        stackPane.getChildren().add(cardView);
        stackPane.getChildren().add(vBox);
        getChildren().add(stackPane);
    }

}

