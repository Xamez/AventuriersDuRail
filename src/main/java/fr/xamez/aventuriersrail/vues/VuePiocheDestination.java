package fr.xamez.aventuriersrail.vues;

import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class VuePiocheDestination extends VBox {

    private final ImageView piocheView;

    private boolean isAnimationFinish = true;

    public VuePiocheDestination() {
        setPrefWidth(100);
        setPrefHeight(140);
        setAlignment(Pos.CENTER);
        setPadding(new Insets(5, 0, 0, 0));
        setSpacing(2);
        Image piocheImage = new Image(getClass().getClassLoader().getResource("images/cartes/destination.png").toString());
        piocheView = new ImageView(piocheImage);
        piocheView.setFitWidth(150);
        piocheView.setPreserveRatio(true);
        Label piocheLabel = new Label("Piocher carte destination");
        piocheLabel.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;");
        getChildren().addAll(piocheView, piocheLabel);
    }

    public void creerBindings() {
        VueMain vueMain = ((VueMain) getScene().getRoot());
        piocheView.setOnMouseClicked(e -> {
            if (!isAnimationFinish) return;
            isAnimationFinish = false;
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), piocheView);
            scaleTransition.setByX(-0.05);
            scaleTransition.setByY(-0.05);
            scaleTransition.setCycleCount(2);
            scaleTransition.setAutoReverse(true);
            scaleTransition.play();
            scaleTransition.setOnFinished(e2 -> {
                piocheView.setScaleX(1);
                piocheView.setScaleY(1);
                isAnimationFinish = true;
            });
            vueMain.getJeu().uneDestinationAEtePiochee();
            vueMain.enableOverlayVue();
        });
    }
}
