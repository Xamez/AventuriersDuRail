package fr.xamez.aventuriersrail.vues;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class VueFenetreDemarrage extends Stage {

    private Runnable actionQuandJouerCliquer;
    private Runnable actionQuandControlesCliquer;

    private Runnable actionQuandRegleCliquer;

    public VueFenetreDemarrage() {
        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.TOP_CENTER);
        VBox vBox = new VBox();
        vBox.setSpacing(40);
        vBox.setAlignment(Pos.CENTER);

        Image background = new Image(getClass().getClassLoader().getResource("images/backgrounds/bg-home-page.png").toString());
        BackgroundImage backgroundImage = new BackgroundImage(background, null, null, null, new BackgroundSize(1, 1, true, true, false, false));
        stackPane.setBackground(new Background(backgroundImage));

        ImageView smokeView = new ImageView(new Image(getClass().getClassLoader().getResource("images/smoke.gif").toString()));
        smokeView.setTranslateX(75);
        smokeView.setTranslateY(-15);
        smokeView.setBlendMode(BlendMode.HARD_LIGHT);

        try {
            Font.loadFont(getClass().getClassLoader().getResource("fonts/bangers.ttf").openStream(), 30);
        } catch (IOException e) {  throw new RuntimeException("Impossible de charger le font " + "bangers.ttf" + "\n" + e); }
        HBox playHbox = new HBox();
        VBox.setMargin(playHbox, new Insets(150, 0, 0, -60));
        playHbox.setMaxWidth(240);
        playHbox.setCursor(Cursor.HAND);
        playHbox.setOnMouseEntered(e -> {
            playHbox.setScaleX(1.1);
            playHbox.setScaleY(1.1);
        });
        playHbox.setOnMouseExited(e -> {
            playHbox.setScaleX(1);
            playHbox.setScaleY(1);
        });
        ImageView playImageView  = new ImageView(new Image(getClass().getClassLoader().getResource("images/icons/play.png").toString()));
        playImageView.setFitWidth(75);
        playImageView.setPreserveRatio(true);
        Button play = new Button("Jouer");
        play.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 36px; -fx-font-family: 'Bangers'; -fx-font-weight: bold;");
        playHbox.getChildren().addAll(playImageView, play);
        playImageView.setOnMouseClicked(e -> actionQuandJouerCliquer.run());
        play.setOnAction(e -> actionQuandJouerCliquer.run());

        HBox commandesHBox = new HBox();
        VBox.setMargin(commandesHBox, new Insets(0, 0, 0, 40));
        commandesHBox.setMaxWidth(340);
        commandesHBox.setCursor(Cursor.HAND);
        commandesHBox.setOnMouseEntered(e -> {
            commandesHBox.setScaleX(1.1);
            commandesHBox.setScaleY(1.1);
        });
        commandesHBox.setOnMouseExited(e -> {
            commandesHBox.setScaleX(1);
            commandesHBox.setScaleY(1);
        });
        ImageView commandesImageView = new ImageView(new Image(getClass().getClassLoader().getResource("images/icons/controls.png").toString()));
        commandesImageView.setFitWidth(75);
        commandesImageView.setPreserveRatio(true);
        Button commandes = new Button("Commandes");
        commandes.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 36px; -fx-font-family: 'Bangers'; -fx-font-weight: bold;");
        commandesHBox.getChildren().addAll(commandesImageView, commandes);
        commandesImageView.setOnMouseClicked(e -> actionQuandControlesCliquer.run());
        commandes.setOnAction(e -> actionQuandControlesCliquer.run());

        HBox reglesHBox = new HBox();
        VBox.setMargin(reglesHBox, new Insets(0, 0, 0, -60));
        reglesHBox.setMaxWidth(240);
        reglesHBox.setCursor(Cursor.HAND);
        reglesHBox.setOnMouseEntered(e -> {
            reglesHBox.setScaleX(1.1);
            reglesHBox.setScaleY(1.1);
        });
        reglesHBox.setOnMouseExited(e -> {
            reglesHBox.setScaleX(1);
            reglesHBox.setScaleY(1);
        });
        ImageView reglesImageView = new ImageView(new Image(getClass().getClassLoader().getResource("images/icons/rules.png").toString()));
        reglesImageView.setFitWidth(75);
        reglesImageView.setPreserveRatio(true);
        Button regles = new Button("Règles");
        regles.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 36px; -fx-font-family: 'Bangers'; -fx-font-weight: bold;");
        reglesHBox.getChildren().addAll(reglesImageView, regles);
        reglesImageView.setOnMouseClicked(e -> actionQuandRegleCliquer.run());
        regles.setOnAction(e -> actionQuandRegleCliquer.run());

        vBox.getChildren().addAll(playHbox, commandesHBox, reglesHBox);

        stackPane.getChildren().addAll(vBox, smokeView);
        smokeView.toFront();
        vBox.toFront();

        Scene scene = new Scene(stackPane, background.getWidth()/2, background.getHeight()/2);

        setScene(scene);
        setTitle("Les aventuriers du rails !");
        setResizable(false);
        centerOnScreen();
    }

    public void setActionQuandRegleCliquer(Runnable action) {
        this.actionQuandRegleCliquer = action;
    }

    public void setActionQuandJouerCliquer(Runnable action) {
        actionQuandJouerCliquer = action;
    }

    public void setActionQuandControlesCliquer(Runnable action) {
        actionQuandControlesCliquer = action;
    }
}
