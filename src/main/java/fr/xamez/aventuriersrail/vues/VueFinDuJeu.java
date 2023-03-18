package fr.xamez.aventuriersrail.vues;

import fr.xamez.aventuriersrail.IJeu;
import fr.xamez.aventuriersrail.IJoueur;
import fr.xamez.aventuriersrail.rails.Joueur;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VueFinDuJeu extends Stage {

    public VueFinDuJeu(IJeu jeu) {
        StackPane stackPane = new StackPane();

        Image background = new Image(getClass().getClassLoader().getResource("images/backgrounds/bg-end-game.jpg").toString());
        ImageView backgroundView = new ImageView(background);
        backgroundView.setEffect(new GaussianBlur(6));
        backgroundView.setFitWidth(background.getWidth() * 1.2);
        backgroundView.setFitHeight(background.getHeight() * 1.2);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.BOTTOM_CENTER);
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.BOTTOM_CENTER);
        hBox.setSpacing(20);

        ArrayList<Joueur> joueurs = new ArrayList<>(jeu.getJoueurs());
        joueurs.sort((j1, j2) -> j2.getScore() - j1.getScore()); // plus grand au plus petit

        vBox.setSpacing(joueurs.get(0).getScore() + 50);

        Label title = new Label(joueurs.get(0).getNom() + " a gagné !");
        title.setStyle("-fx-text-fill: #FF7B00; -fx-font-size: 36px; -fx-font-family: 'Bangers'; -fx-font-weight: bold;");
        title.setTranslateY(10);

        for (Joueur j : joueurs) {
            int score = j.getScore();
            VBox joueurBox = new VBox();
            Label nomLabel = new Label(j.getNom());
            Label scoreLabel = new Label(score + " points");
            nomLabel.setStyle("-fx-text-fill: #FF7B00; -fx-font-size: 16; -fx-font-weight: bold");
            if (j.equals(joueurs.get(0)))
                scoreLabel.setStyle("-fx-text-fill: #FF7B00; -fx-font-size: 13px; -fx-font-weight: bold;");
            else
                scoreLabel.setStyle("-fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold;");

            ImageView imageView = new ImageView(VueDuJeu.IMAGES_JOUEURS.get(j));
            imageView.setFitWidth(80);
            imageView.setPreserveRatio(true);
            if (score < 0) score *= -1;
            Rectangle rectangle = new Rectangle(100, score, getColor(j.getCouleur())); // todo 300 lié au score
            joueurBox.getChildren().addAll(imageView, nomLabel, scoreLabel, rectangle);
            if (j.getScore() > 0) {
                int finalScore = score;
                joueurBox.getChildren().forEach(n -> n.setTranslateY(-finalScore));
            }
            joueurBox.setAlignment(Pos.TOP_CENTER);
            hBox.getChildren().add(joueurBox);
        }

        vBox.getChildren().addAll(title, hBox);
        stackPane.getChildren().addAll(backgroundView, vBox);
        backgroundView.toBack();
        vBox.toFront();

        Scene scene = new Scene(stackPane, background.getWidth() * 1.2, background.getHeight() * 1.2);

        setScene(scene);
        setTitle("Les aventuriers du rail !");
        setResizable(false);
        centerOnScreen();
    }

    private Color getColor(IJoueur.Couleur couleur) {
        return switch (couleur) {
            case ROUGE -> Color.valueOf("#dd1814");
            case BLEU -> Color.valueOf("#0c3cb7");
            case VERT -> Color.valueOf("#95bf07");
            case JAUNE -> Color.valueOf("#ffd954");
            case ROSE -> Color.valueOf("#ac44d5");
        };
    }

}
