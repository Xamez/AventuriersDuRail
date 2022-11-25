package fr.xamez.aventuriersrail.vues;

import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class VueJoueur extends HBox {

    private final VueCarteProfileJoueur vueCarteProfileJoueur;
    private final VueCarteDestinationJoueurCourant vueCarteDestinationJoueurCourant;
    private final VueCartesJoueurCourant vueCartesJoueurCourant;

    private final ImageView toggleOrb;
    private final ScaleTransition scaleTransition;
    private final Button passer;

    private boolean areDestinationVisible = false;

    public VueJoueur() {
        vueCarteProfileJoueur = new VueCarteProfileJoueur();

        Image orb = new Image(getClass().getClassLoader().getResource("images/player/orb.png").toString());
        toggleOrb = new ImageView(orb);
        toggleOrb.setEffect(new Glow(3));
        toggleOrb.setFitHeight(25);
        toggleOrb.setTranslateX(-92);
        toggleOrb.setTranslateY(110);
        toggleOrb.setPreserveRatio(true);
        scaleTransition = new ScaleTransition(Duration.millis(450), toggleOrb);
        scaleTransition.setByX(0.2);
        scaleTransition.setByY(0.2);
        scaleTransition.setCycleCount(-1);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();

        Rectangle seperator = new Rectangle(0, 0, 4, 100);
        seperator.setFill(Color.valueOf("#e0c9b1"));
        seperator.setArcWidth(10);
        seperator.setArcHeight(10);
        seperator.setOpacity(0.4);
        seperator.setTranslateX(10);
        seperator.setTranslateY(20);

        vueCartesJoueurCourant = new VueCartesJoueurCourant();
        vueCartesJoueurCourant.setPadding(new Insets(0, 0, 0, 30));
        HBox.setMargin(vueCartesJoueurCourant, new Insets(10, 0, 0, 0));

        vueCarteDestinationJoueurCourant = new VueCarteDestinationJoueurCourant();
        vueCarteDestinationJoueurCourant.setVisible(false);
        vueCarteDestinationJoueurCourant.setManaged(false);

        passer = new Button("Passer");
        passer.setStyle("-fx-background-color: #e0c9b1;");
        HBox.setMargin(passer, new Insets(55, 0, 0, 10));

        getChildren().addAll(vueCarteProfileJoueur, toggleOrb, seperator, vueCartesJoueurCourant, vueCarteDestinationJoueurCourant, passer);
    }

    public void creerBindings() {
        vueCarteProfileJoueur.creerBindings();
        vueCartesJoueurCourant.creerBindings();
        vueCarteDestinationJoueurCourant.creerBindings();

        passer.setOnAction(e -> ((VueMain) getScene().getRoot()).getJeu().passerAEteChoisi());
        toggleOrb.setOnMouseClicked(e -> {
            scaleTransition.stop();
            toggleOrb.setScaleX(1); // on remet le scale à 1 une fois l'animation terminée
            toggleOrb.setScaleY(1);
            areDestinationVisible = !areDestinationVisible;
            if (areDestinationVisible) {
                vueCarteDestinationJoueurCourant.setVisible(true);
                vueCarteDestinationJoueurCourant.setManaged(true);
                vueCartesJoueurCourant.setVisible(false);
                vueCartesJoueurCourant.setManaged(false);
                HBox.setMargin(passer, new Insets(55, 0, 0, 50));
            } else {
                vueCarteDestinationJoueurCourant.setVisible(false);
                vueCarteDestinationJoueurCourant.setManaged(false);
                vueCartesJoueurCourant.setVisible(true);
                vueCartesJoueurCourant.setManaged(true);
                HBox.setMargin(passer, new Insets(55, 0, 0, 10));
            }
        });
    }

}
