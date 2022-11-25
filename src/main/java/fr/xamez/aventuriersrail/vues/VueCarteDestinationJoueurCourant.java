package fr.xamez.aventuriersrail.vues;

import fr.xamez.aventuriersrail.rails.Destination;
import javafx.application.Platform;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;

import java.util.List;

public class VueCarteDestinationJoueurCourant extends ScrollPane {

    private final HBox destinations;

    public VueCarteDestinationJoueurCourant() {
        destinations = new HBox();
        destinations.setAlignment(Pos.CENTER);
        getStyleClass().add("scroll-pane");
        setContent(destinations);
        setTranslateX(40);
        setTranslateY(30);
        setPrefWidth(540);
        destinations.setSpacing(12);
        setHbarPolicy(ScrollBarPolicy.NEVER);
        setVbarPolicy(ScrollBarPolicy.NEVER);
        setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
    }

    public void creerBindings() {
        ((VueMain) getScene().getRoot()).getJeu().joueurCourantProperty().addListener((observableValue, ancienJoueur, nouveauJoueur) -> Platform.runLater(() -> {
            destinations.getChildren().clear();
            afficherCartesDestinationJoueur(nouveauJoueur.getDestinations());
        }));
        setOnScroll(e -> {
            if(e.getDeltaX() == 0 && e.getDeltaY() != 0)
                setHvalue(getHvalue() - e.getDeltaY() / destinations.getWidth());
        });
    }

    private void afficherCartesDestinationJoueur(List<Destination> cartesDestination) {
        cartesDestination.forEach(destination -> {
            VueDestination vueCarteDestination = new VueDestination(destination, false);
            destinations.getChildren().add(vueCarteDestination);
        });
    }

}
