package fr.xamez.aventuriersrail.rails;

import fr.xamez.aventuriersrail.IRoute;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.HashMap;

public class Route implements IRoute {
    /**
     * Première extrêmité
     */
    private Ville ville1;
    /**
     * Deuxième extrêmité
     */
    private Ville ville2;
    /**
     * Nombre de segments
     */
    private int longueur;
    /**
     * Couleur pour capturer la route (éventuellement GRIS mais pas LOCOMOTIVE)
     */
    private CouleurWagon couleur;
    /**
     * Joueur qui a capturé la route (`null` si la route est encore à prendre)
     */
    private ObjectProperty<Joueur> proprietaire;

    /**
     * Nom unique de la route. Ce nom est nécessaire pour résoudre l'ambiguïté entre les routes doubles
     * (voir la classe Plateau pour plus de clarté)
     */
    private String nom;

    public Route(Ville ville1, Ville ville2, int longueur, CouleurWagon couleur) {
        this.ville1 = ville1;
        this.ville2 = ville2;
        this.nom = ville1.getNom() + " - " + ville2.getNom();
        this.longueur = longueur;
        this.couleur = couleur;
        this.proprietaire = new SimpleObjectProperty<>();;
    }

    public Ville getVille1() {
        return ville1;
    }

    public Ville getVille2() {
        return ville2;
    }

    public int getLongueur() {
        return longueur;
    }

    public CouleurWagon getCouleur() {
        return couleur;
    }

    public Joueur getProprietaire() {
        return proprietaire.getValue();
    }

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire.setValue(proprietaire);
    }

    public ObjectProperty<Joueur> proprietaireProperty() {
        return proprietaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return un objet simple représentant les informations de la route
     */
    public Object asPOJO() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("nom", getNom());
        if (proprietaire != null) {
            data.put("proprietaire", proprietaire.getValue().getCouleur());
        }
        return data;
    }

    /**
     * Détermine si un joueur a assez de cartes wagon pour capturer la route
     * 
     * @param joueur le joueur qui essaie de capturer la route
     * @return true si la liste des cartes wagon du joueur est suffisante pour
     *         couvrir le prix de capture de la route.
     */
    public boolean peutCapturerParJoueur(Joueur joueur) {
        return joueur.peutPayerCartesWagon(longueur, couleur, 0);
    }

    /**
     * Méthode appelée lorsqu'un joueur capture la route.
     * 
     * Cette méthode fait défausser au joueur les cartes wagon nécessaires, puis
     * modifie l'attribut `proprietaire` de la route.
     *
     * Pré-requis : le joueur a les cartes wagon nécessaires pour capturer la route
     * 
     * @param joueur
     */
    public boolean capturerParJoueur(Joueur joueur) {
        joueur.payerCartesWagon(
                longueur, couleur, 0,
                String.format("Défaussez des cartes wagon pour capturer la route %s - %s",
                        ville1.getNom(),
                        ville2.getNom()));
        joueur.defausserCartesWagonPosees();
        return true;
    }

}
