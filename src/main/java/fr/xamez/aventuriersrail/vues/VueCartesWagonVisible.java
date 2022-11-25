package fr.xamez.aventuriersrail.vues;

import fr.xamez.aventuriersrail.IJeu;
import fr.xamez.aventuriersrail.rails.CouleurWagon;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * Cette classe représente la vue d'une carte Destination.
 *
 * On y définit le listener à exécuter lorsque cette carte a été choisie par l'utilisateur
 */
public class VueCartesWagonVisible extends VBox {

    private IJeu jeu;

    public VueCartesWagonVisible() {
        setPrefHeight(450);
        setSpacing(5);
    }

    private ListChangeListener<CouleurWagon> couleurWagonListChangeListener = change -> {
        Platform.runLater(() -> {
            getChildren().clear();
            jeu.cartesWagonVisiblesProperty().stream().toList().forEach(this::afficherCarteWagonVisible);
        });
    };

    public void creerBindings() {
        jeu = ((VueMain) getScene().getRoot()).getJeu();
        jeu.cartesWagonVisiblesProperty().addListener(couleurWagonListChangeListener);
    }

    private void afficherCarteWagonVisible(CouleurWagon carteWagonVisible) {
        VueCarteWagon vueCarteWagonVisible = new VueCarteWagon(carteWagonVisible, 0);
        TranslateTransition translateTransitionIn = new TranslateTransition(new Duration(200), vueCarteWagonVisible);
        TranslateTransition translateTransitionOut = new TranslateTransition(new Duration(200), vueCarteWagonVisible);
        double layoutX = vueCarteWagonVisible.getLayoutX();
        translateTransitionIn.setToX(layoutX + 15);
        translateTransitionOut.setToX(layoutX);
        vueCarteWagonVisible.setOnMouseEntered(e -> translateTransitionIn.play());
        vueCarteWagonVisible.setOnMouseExited(e ->  translateTransitionOut.play());
        vueCarteWagonVisible.setOnMouseClicked(e -> {
            FadeTransition fadeTransition = new FadeTransition(new Duration(400), vueCarteWagonVisible);
            fadeTransition.setToValue(0);
            fadeTransition.play();
            fadeTransition.setOnFinished(e2 -> {
                jeu.uneCarteWagonAEteChoisie(carteWagonVisible);
                /**
                 * Il existe un cas dans les règles qui interdit le joueur de prendre une locomotive. Or, nous avons déjà
                 * supprimer la carte visible donc on doit la réafficher en déclenchant manuellement le onChanged
                 */
                if (carteWagonVisible == CouleurWagon.LOCOMOTIVE)
                    couleurWagonListChangeListener.onChanged(null);
            });
        });
        getChildren().add(vueCarteWagonVisible);
    }

}
