package fr.xamez.aventuriersrail.vues;

import fr.xamez.aventuriersrail.IJeu;
import fr.xamez.aventuriersrail.IJoueur;
import fr.xamez.aventuriersrail.rails.CouleurWagon;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.List;

/**
 * Cette classe présente les éléments appartenant au joueur courant.
 *
 * On y définit les bindings sur le joueur courant, ainsi que le listener à exécuter lorsque ce joueur change
 */
public class VueCartesJoueurCourant extends HBox {

    private IJeu jeu;

    public VueCartesJoueurCourant() {
        setSpacing(-40);
        setPrefWidth(580);
        setMaxHeight(120);
    }

    public void creerBindings() {
        jeu = ((VueMain) getScene().getRoot()).getJeu();
        jeu.joueurCourantProperty().addListener((observableValue, ancienJoueur, nouveauJoueur) -> updatePlayerCards(nouveauJoueur));
        jeu.getJoueurs().forEach(joueur -> joueur.cartesWagonProperty().addListener((ListChangeListener<CouleurWagon>) change -> updatePlayerCards(joueur)));
    }

    private void updatePlayerCards(IJoueur joueur) {
        Platform.runLater(() -> {
            getChildren().clear();
            afficherCartesWagonJoueur(joueur.getCartesWagon());
        });
    }

    private void afficherCartesWagonJoueur(List<CouleurWagon> cartesWagon) {
        HashMap<CouleurWagon, Integer> cartesWagonJoueur = new HashMap<>();
        for (CouleurWagon wagon : cartesWagon)
            if (cartesWagonJoueur.containsKey(wagon))
                cartesWagonJoueur.put(wagon, cartesWagonJoueur.get(wagon) + 1);
            else
                cartesWagonJoueur.put(wagon, 1);
        cartesWagonJoueur.forEach((couleurWagon, nb) -> {
            VueCarteWagon vueCarteWagon = new VueCarteWagon(couleurWagon, nb);
            TranslateTransition translateTransitionIn = new TranslateTransition(new Duration(200), vueCarteWagon);
            TranslateTransition translateTransitionOut = new TranslateTransition(new Duration(200), vueCarteWagon);
            double layoutY = vueCarteWagon.getLayoutY();
            translateTransitionIn.setToY(layoutY - 15);
            translateTransitionOut.setToY(layoutY);
            vueCarteWagon.setOnMouseEntered(e -> translateTransitionIn.play());
            vueCarteWagon.setOnMouseExited(e ->  translateTransitionOut.play());
            vueCarteWagon.setOnMouseClicked(e -> jeu.uneCarteWagonAEteChoisie(couleurWagon));
            getChildren().add(vueCarteWagon);
        });
    }

}
