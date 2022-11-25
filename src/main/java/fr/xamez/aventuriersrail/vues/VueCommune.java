package fr.xamez.aventuriersrail.vues;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class VueCommune extends VBox {

    private final VuePiocheDestination vuePiocheDestination;
    private final VueCartesWagonVisible vueCartesWagonVisible;
    private final VuePiocheCarteWagon vuePiocheCarteWagon;

    public VueCommune() {
        vuePiocheDestination = new VuePiocheDestination();

        vueCartesWagonVisible = new VueCartesWagonVisible();
        setMargin(vueCartesWagonVisible, new Insets(5, 0, 0, 20));

        vuePiocheCarteWagon = new VuePiocheCarteWagon();

        getChildren().addAll(vuePiocheDestination, vueCartesWagonVisible, vuePiocheCarteWagon);
    }

    public void creerBindings() {
        vuePiocheDestination.creerBindings();
        vueCartesWagonVisible.creerBindings();
        vuePiocheCarteWagon.creerBindings();
    }

}
