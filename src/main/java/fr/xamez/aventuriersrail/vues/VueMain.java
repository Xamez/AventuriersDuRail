package fr.xamez.aventuriersrail.vues;

import fr.xamez.aventuriersrail.IJeu;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class VueMain extends StackPane {

    private final IJeu jeu;

    private final Label instructions;
    private final VueDuJeu main;
    private final VueSelectionCarteDestination overlay;

    public VueMain(IJeu jeu) {
        this.jeu = jeu;
        instructions = new Label("");
        instructions.setPadding(new Insets(3, 8, 3, 8));
        instructions.setStyle("-fx-font-size: 16px; -fx-font-weight: 600; -fx-background-radius: 20, 20, 20, 20; -fx-background-color: rgba(224, 201, 177, 0.8);");
        instructions.setTranslateY(-330);
        main = new VueDuJeu(jeu);
        overlay = new VueSelectionCarteDestination(jeu);
        getChildren().addAll(main, overlay, instructions);
        main.toBack();
        main.setDisable(true);
        overlay.toFront();
        instructions.toFront();
        instructions.setDisable(true); // permet de pouvoir cliquer à travers si les le texte d'instruction est trop long et empiète sur un route ou une ville
        instructions.getStyleClass().add("instructions");

    }

    public void creerBindings() {
        main.creerBindings();
        overlay.creerBindings();
        instructions.textProperty().bind(jeu.instructionProperty());
    }

    public void enableOverlayVue() {
        main.setDisable(true);
        overlay.setVisible(true);
        overlay.checkDoitEtreFermer();
    }

    public void enableMainVue() {
        main.setDisable(false);
        overlay.setVisible(false);
    }

    public IJeu getJeu() {
        return jeu;
    }
}
