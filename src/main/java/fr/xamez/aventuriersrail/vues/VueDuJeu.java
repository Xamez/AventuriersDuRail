package fr.xamez.aventuriersrail.vues;

import fr.xamez.aventuriersrail.IJeu;
import fr.xamez.aventuriersrail.rails.Joueur;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.util.HashMap;

/**
 * Cette classe correspond à la fenêtre principale de l'application.
 *
 * Elle est initialisée avec une référence sur la partie en cours (Jeu).
 *
 * On y définit les bindings sur les éléments internes qui peuvent changer
 * (le joueur courant, les 5 cartes Wagons visibles, les destinations lors de l'étape d'initialisation de la partie, ...)
 * ainsi que les listeners à exécuter lorsque ces éléments changent
 */
public class VueDuJeu extends StackPane {

    private final IJeu jeu;
    private final GridPane gridPane;
    private final VueCommune vueCommune;
    private final VuePlateau plateau;
    private final VueJoueur vueJoueur;

    public static HashMap<Joueur, Image> IMAGES_JOUEURS = new HashMap<>();
    public static HashMap<Joueur, Image> IMAGES_GARES = new HashMap<>();
    public static HashMap<Joueur, Image> IMAGES_WAGONS = new HashMap<>();

    public VueDuJeu(IJeu jeu) {
        this.jeu = jeu;

        for (int i = 0; i < jeu.getJoueurs().size(); i++) { // le nombre de joueur sera forcément <= 5
            Joueur joueur = jeu.getJoueurs().get(i);
            IMAGES_JOUEURS.put(joueur, new Image(getClass().getClassLoader().getResource("images/players/avatar-" + joueur.getCouleur() + ".png").toString()));
            IMAGES_GARES.put(joueur, new Image(getClass().getClassLoader().getResource("images/gares/gare-" + joueur.getCouleur() + ".png").toString()));
            IMAGES_WAGONS.put(joueur, new Image(getClass().getClassLoader().getResource("images/wagons/image-wagon-" + joueur.getCouleur() + ".png").toString()));
        }

        plateau = new VuePlateau(jeu);

        gridPane = new GridPane();

        Pane topPane = new Pane();
        topPane.getStyleClass().add("topPane");
        gridPane.add(topPane, 1, 0, 2, 1);

        vueCommune = new VueCommune();
        vueCommune.getStyleClass().add("leftPane");
        gridPane.add(vueCommune, 0, 0, 1, 3);

        gridPane.add(plateau, 1, 1);

        Pane rightPane = new Pane();
        rightPane.getStyleClass().add("rightPane");
        gridPane.add(rightPane, 2, 1, 1, 1);

        vueJoueur = new VueJoueur();
        vueJoueur.getStyleClass().add("bottomPane");
        gridPane.add(vueJoueur, 1, 2, 2, 1);

        getChildren().add(gridPane);
    }

    public void creerBindings() {
        vueCommune.creerBindings();
        vueJoueur.creerBindings();
        plateau.creerBindings();

    }

}