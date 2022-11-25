package fr.xamez.aventuriersrail.vues;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VueFenetreControles extends Stage {

    private Runnable actionSurDerniereFleche;

    private final ArrayList<Image> frames = new ArrayList<>();

    private int currentFrame = 0; // 0 - 14

    public VueFenetreControles() {

        for (int i = 1; i < 16; i++) // frame-1 à frame-15
            frames.add(new Image(getClass().getClassLoader().getResource("images/controles/frame-" + i + ".png").toString()));

        ImageView leftArrow = new ImageView(new Image(getClass().getClassLoader().getResource("images/icons/arrow-left.png").toString()));
        leftArrow.setFitWidth(40);
        leftArrow.setPreserveRatio(true);
        ImageView rightArrow = new ImageView(new Image(getClass().getClassLoader().getResource("images/icons/arrow-right.png").toString()));
        rightArrow.setFitWidth(40);
        rightArrow.setPreserveRatio(true);

        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.CENTER);
        stackPane.setPadding(new Insets(0));

        ImageView frameView = new ImageView(frames.get(currentFrame));

        Button previousButton = new Button();
        previousButton.setVisible(false);
        previousButton.setGraphic(leftArrow);
        previousButton.setCursor(Cursor.HAND);
        previousButton.setOnMouseEntered(e -> {
            previousButton.setScaleX(1.1);
            previousButton.setScaleY(1.1);
        });
        previousButton.setOnMouseExited(e -> {
            previousButton.setScaleX(1);
            previousButton.setScaleY(1);
        });
        previousButton.setStyle("-fx-background-color: #FF7B00; -fx-background-radius: 50;");
        previousButton.setPadding(new Insets(8));
        Button nextButton = new Button();
        nextButton.setGraphic(rightArrow);
        nextButton.setCursor(Cursor.HAND);
        nextButton.setOnMouseEntered(e -> {
            nextButton.setScaleX(1.2);
            nextButton.setScaleY(1.2);
        });
        nextButton.setOnMouseExited(e -> {
            nextButton.setScaleX(1);
            nextButton.setScaleY(1);
        });
        nextButton.setPadding(new Insets(8));
        nextButton.setStyle("-fx-background-color: #FF7B00; -fx-background-radius: 50;");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(previousButton, nextButton);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(frames.get(0).getWidth() - 150);

        previousButton.setOnMouseClicked(e -> {
            if (currentFrame > 0)
                frameView.setImage(frames.get(--currentFrame));
            previousButton.setVisible(currentFrame != 0);
        });

        nextButton.setOnMouseClicked(e -> {
            if (currentFrame == frames.size() - 1) actionSurDerniereFleche.run();
            if (currentFrame < frames.size() - 1)
                frameView.setImage(frames.get(++currentFrame));
            previousButton.setVisible(currentFrame != 0);
        });

        stackPane.getChildren().addAll(frameView, hBox);
        frameView.toBack();
        rightArrow.toFront();
        leftArrow.toFront();

        Scene scene = new Scene(stackPane, frames.get(0).getWidth(), frames.get(0).getHeight());

        setScene(scene);
        setTitle("Rails - Contrôles");
        setResizable(false);
        centerOnScreen();
    }

    public void setActionSurDerniereFleche(Runnable action) {
        actionSurDerniereFleche = action;
    }
}
