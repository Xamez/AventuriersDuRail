package fr.xamez.aventuriersrail.vues;

import fr.xamez.aventuriersrail.IDestination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Cette classe représente la vue d'une carte Destination.
 *
 * On y définit le listener à exécuter lorsque cette carte a été choisie par l'utilisateur
 */
public class VueDestination extends Pane {

    private final IDestination destination;

    public VueDestination(IDestination destination, boolean estDebutDuJeu) {
        this.destination = destination;
        String nomDestination = destination.getNom().toLowerCase().replaceAll("[ ()0-9]", "");
        Image image = new Image(getClass().getClassLoader().getResource("images/cartes/destinations/eu-" + nomDestination + ".png").toString());
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        if (estDebutDuJeu) // cas = 1 (pour les destinations à choisir avant le jeu)
            imageView.setFitWidth(200);
        else
            imageView.setFitWidth(130);
        getChildren().addAll(imageView);
    }

    public IDestination getDestination() {
        return destination;
    }

}
