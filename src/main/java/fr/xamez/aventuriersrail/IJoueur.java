package fr.xamez.aventuriersrail;

import fr.xamez.aventuriersrail.rails.CouleurWagon;
import fr.xamez.aventuriersrail.rails.Destination;
import javafx.collections.ObservableList;

import java.util.List;

public interface IJoueur {

    ObservableList<CouleurWagon> cartesWagonProperty();

    public static enum Couleur {
        JAUNE, ROUGE, BLEU, VERT, ROSE;
    }

    List<CouleurWagon> getCartesWagon();
    List<Destination> getDestinations();
    int getNbWagons();
    String getNom();
    Couleur getCouleur();
    int getNbGares();
    int getScore();
}