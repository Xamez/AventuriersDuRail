package fr.xamez.aventuriersrail;

import fr.xamez.aventuriersrail.rails.Joueur;
import javafx.beans.property.ObjectProperty;

public interface IRoute {
    ObjectProperty<Joueur> proprietaireProperty();
    String getNom();
}