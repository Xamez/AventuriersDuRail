package fr.xamez.aventuriersrail.rails;

import fr.xamez.aventuriersrail.ICouleurWagon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Représentation des couleurs du jeu utilisées pour les cartes wagon et les routes
 */
public enum CouleurWagon implements ICouleurWagon {
    NOIR, BLANC, JAUNE, ROUGE, ORANGE, BLEU, VERT, ROSE, GRIS, LOCOMOTIVE;

    @Override
    public String toString() {
        return switch (this) {
            case NOIR -> "Noir";
            case BLANC -> "Blanc";
            case JAUNE -> "Jaune";
            case ROUGE -> "Rouge";
            case ORANGE -> "Orange";
            case BLEU -> "Bleu";
            case VERT -> "Vert";
            case ROSE -> "Rose";
            case GRIS -> "Gris"; // représente un couleur indéterminée
            case LOCOMOTIVE -> "Locomotive"; // peut remplacer n'importe quelle couleur
        };
    }

    /**
     * Renvoie la liste des couleurs "simples" c'est-à-dire sans LOCOMOTIVE ni GRIS
     */
    public static ArrayList<CouleurWagon> getCouleursSimples() {
        return new ArrayList<>(List.of(NOIR, BLANC, JAUNE, ROUGE, ORANGE, BLEU, VERT, ROSE));
    }

    /**
     * Renvoie un tableau associatif indiquant pour chaque couleur le nombre
     * d'éléments de cette couleur dans la liste passée en paramètre.
     * 
     * La valeur associée à la couleur GRIS est la plus grande valeur des autres
     * couleurs normales (hors LOCOMOTIVE).
     * 
     * @param couleurs une liste de couleurs (ne devrait pas contenir GRIS)
     * @return un tableau associatif de la forme {@code {couleur: nombre
     *         d'éléments}}
     */
    public static Map<CouleurWagon, Integer> compteur(List<CouleurWagon> couleurs) {
        HashMap<CouleurWagon, Integer> c = new HashMap<>();
        // initialisation
        for (CouleurWagon couleur : CouleurWagon.values()) {
            c.put(couleur, 0);
        }
        // décompte des valeurs dans la liste `couleurs`
        for (CouleurWagon couleur : couleurs) {
            c.put(couleur, c.get(couleur) + 1);
        }

        // la valeur correspondant à GRIS est le max des autres valeurs hors LOCOMOTIVE
        for (CouleurWagon couleur : CouleurWagon.values()) {
            if (couleur != CouleurWagon.LOCOMOTIVE && couleur != CouleurWagon.GRIS) {
                c.put(CouleurWagon.GRIS, Math.max(c.get(CouleurWagon.GRIS), c.get(couleur)));
            }
        }
        return c;
    }
}
