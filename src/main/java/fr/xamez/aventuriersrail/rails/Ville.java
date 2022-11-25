package fr.xamez.aventuriersrail.rails;

import fr.xamez.aventuriersrail.IVille;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Ville implements IVille {
    /**
     * Nom complet de la ville
     */
    private String nom;
    /**
     * Joueur qui a construit une gare sur la ville (ou `null` si pas de gare)
     */
    private ObjectProperty<Joueur> proprietaire;

    public Ville(String nom) {
        this.nom = nom;
        proprietaire = new SimpleObjectProperty<>();
    }

    public String getNom() {
        return nom;
    }
    
    public Joueur getProprietaire() {
        return proprietaire.getValue();
    }

    public ObjectProperty<Joueur> proprietaireProperty() {
        return proprietaire;
    }

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire.setValue(proprietaire);
    }
    
    @Override
    public String toString() {
        return nom;
    }
}