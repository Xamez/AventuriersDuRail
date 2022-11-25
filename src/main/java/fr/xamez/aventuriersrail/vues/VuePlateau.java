package fr.xamez.aventuriersrail.vues;

import fr.xamez.aventuriersrail.IJeu;
import fr.xamez.aventuriersrail.IRoute;
import fr.xamez.aventuriersrail.IVille;
import javafx.application.Platform;
import javafx.beans.binding.DoubleBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

/**
 * Cette classe présente les routes et les villes sur le plateau.
 *
 * On y définit le listener à exécuter lorsque qu'un élément du plateau a été choisi par l'utilisateur
 * ainsi que les bindings qui mettront ?à jour le plateau après la prise d'une route ou d'une ville par un joueur
 */
public class VuePlateau extends StackPane {

    private IJeu jeu;

    private ImageView toggleButton;

    private Pane routesView;

    @FXML
    ImageView imageView;
    @FXML
    private Group villes;
    @FXML
    private Group routes;

    public VuePlateau(IJeu jeu) {
        this.jeu = jeu;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/plateau.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setPrefWidth(918);
        setPrefHeight(590);
        toggleButton = new ImageView(getClass().getClassLoader().getResource("images/plateau/toggle-button.png").toString());
        toggleButton.setFitWidth(50);
        toggleButton.setPreserveRatio(true);
        toggleButton.setTranslateX(-420);
        toggleButton.setTranslateY(-255);
        getChildren().add(toggleButton);
        routesView = new Pane();
        routesView.prefWidth(getPrefWidth());
        routesView.prefHeight(getPrefHeight());
        getChildren().add(routesView);
        toBack();
        routesView.toFront();
        routes.toFront();
        villes.toFront();
        toggleButton.toFront();
    }

    public void creerBindings() {
        bindRedimensionPlateau();
        toggleButton.setOnMouseClicked(e -> {
            if (imageView.getOpacity() == 1)
                imageView.setOpacity(0.4);
            else
                imageView.setOpacity(1);
        });
    }

    @FXML
    public void choixRouteOuVille(MouseEvent e) {
        if (e.getTarget() instanceof Rectangle g) {
            String id = g.getParent().getId();
            if (getRouteParNom(id).proprietaireProperty().get() == null)
                jeu.uneVilleOuUneRouteAEteChoisie(id);
        } else if (e.getTarget() instanceof Circle c)
            if (getVilleParNom(c.getId()).proprietaireProperty().get() == null)
                jeu.uneVilleOuUneRouteAEteChoisie(c.getId());
    }

    private IRoute getRouteParNom(String nom) {
        return jeu.getRoutes().stream().map(n -> (IRoute) n).filter(r -> r.getNom().equals(nom)).findFirst().get();
    }

    private IVille getVilleParNom(String nom) {
        return jeu.getVilles().stream().map(n -> (IVille) n).filter(r -> r.getNom().equals(nom)).findFirst().get();
    }

    private void bindRedimensionPlateau() {
        bindRoutes();
        bindVilles();
//        Les dimensions de l'image varient avec celle de la scène
        imageView.fitWidthProperty().bind(new DoubleBinding() {
            {
                super.bind(getScene().widthProperty(), getScene().heightProperty());
            }
            @Override
            protected double computeValue() {
                return getScene().getWidth() - 160;
            }
        });
        imageView.fitHeightProperty().bind(new DoubleBinding() {
            {
                super.bind(getScene().widthProperty(), getScene().heightProperty());
            }
            @Override
            protected double computeValue() {
                return getScene().getHeight() - 140;
            }
        });
    }

    private void bindRectangle(Rectangle rect, double layoutX, double layoutY) {
        rect.widthProperty().bind(new DoubleBinding() {
            {
                super.bind(imageView.fitWidthProperty(), imageView.fitHeightProperty());
            }
            @Override
            protected double computeValue() {
                return DonneesPlateau.largeurRectangle * imageView.getLayoutBounds().getWidth() / DonneesPlateau.largeurInitialePlateau;
            }
        });
        rect.heightProperty().bind(new DoubleBinding() {
            {
                super.bind(imageView.fitWidthProperty(), imageView.fitHeightProperty());
            }
            @Override
            protected double computeValue() {
                return DonneesPlateau.hauteurRectangle * imageView.getLayoutBounds().getHeight() / DonneesPlateau.hauteurInitialePlateau;
            }
        });
        rect.layoutXProperty().bind(new DoubleBinding() {
            {
                super.bind(imageView.fitWidthProperty(), imageView.fitHeightProperty());
            }
            @Override
            protected double computeValue() {
                return layoutX * imageView.getLayoutBounds().getWidth() / DonneesPlateau.largeurInitialePlateau + 8;
            }
        });
        rect.layoutYProperty().bind(new DoubleBinding() {
            {
                super.bind(imageView.fitWidthProperty(), imageView.fitHeightProperty());
            }
            @Override
            protected double computeValue() {
                return layoutY * imageView.getLayoutBounds().getHeight() / DonneesPlateau.hauteurInitialePlateau;
            }
        });
    }

    private void bindRoutes() {
        jeu.getRoutes().forEach(r -> {
            IRoute route = (IRoute) r;
            route.proprietaireProperty().addListener((observableValue, ancienJoueur, nouveauJoueur) -> Platform.runLater(() -> routes.getChildren().iterator().forEachRemaining(n -> {
                if (n.getId() != null && n.getId().equals(route.getNom())) {
                    Group group = (Group) n;
                    ObservableList<Node> children = FXCollections.observableArrayList(group.getChildren());
                    children.iterator().forEachRemaining(rect -> {
                        ImageView routeView = new ImageView(VueDuJeu.IMAGES_WAGONS.get(nouveauJoueur));
                        routeView.setFitWidth(50);
                        routeView.setPreserveRatio(true);
                        routeView.setLayoutX(rect.getLayoutX() - rect.getLayoutBounds().getWidth());
                        routeView.setLayoutY(rect.getLayoutY() - rect.getLayoutBounds().getHeight() * 2 - 5);
                        routeView.setRotate(rect.getRotate());
                        routesView.getChildren().add(routeView);
                    });
                }
            })));
        });
        for (Node nRoute : routes.getChildren()) {
            Group gRoute = (Group) nRoute;
            int numRect = 0;
            for (Node nRect : gRoute.getChildren()) {
                Rectangle rect = (Rectangle) nRect;
                bindRectangle(rect, DonneesPlateau.getRoute(nRoute.getId()).get(numRect).getLayoutX(), DonneesPlateau.getRoute(nRoute.getId()).get(numRect).getLayoutY());
                numRect++;
            }
        }
    }

    private void bindVilles() {
        jeu.getVilles().forEach(v -> {
            IVille ville = (IVille) v;
            ville.proprietaireProperty().addListener((observableValue, ancienJoueur, nouveauJoueur) -> Platform.runLater(() -> {
                ImageView villeView = new ImageView(VueDuJeu.IMAGES_GARES.get(nouveauJoueur));
                villeView.setFitWidth(30);
                villeView.setPreserveRatio(true);
                villes.getChildren().stream().filter(n -> n.getId().equals(ville.getNom())).findFirst().ifPresent(n -> {
                    villeView.setLayoutX(n.getLayoutX() - villeView.getLayoutBounds().getWidth() + 12);
                    villeView.setLayoutY(n.getLayoutY() - villeView.getLayoutBounds().getHeight() + 10);
                });
                villes.getChildren().add(villeView);
            }));
        });
        for (Node nVille : villes.getChildren()) {
            Circle ville = (Circle) nVille;
            bindVille(ville, DonneesPlateau.getVille(ville.getId()).getLayoutX(), DonneesPlateau.getVille(ville.getId()).getLayoutY());
        }
    }

    private void bindVille(Circle ville, double layoutX, double layoutY) {
        ville.layoutXProperty().bind(new DoubleBinding() {
            {
                super.bind(imageView.fitWidthProperty(), imageView.fitHeightProperty());
            }
            @Override
            protected double computeValue() {
                return layoutX * imageView.getLayoutBounds().getWidth() / DonneesPlateau.largeurInitialePlateau;
            }
        });
        ville.layoutYProperty().bind(new DoubleBinding() {
            {
                super.bind(imageView.fitWidthProperty(), imageView.fitHeightProperty());
            }
            @Override
            protected double computeValue() {
                return layoutY * imageView.getLayoutBounds().getHeight()/ DonneesPlateau.hauteurInitialePlateau;
            }
        });
        ville.radiusProperty().bind(new DoubleBinding() {
            { super.bind(imageView.fitWidthProperty(), imageView.fitHeightProperty());}
            @Override
            protected double computeValue() {
                return DonneesPlateau.rayonInitial * imageView.getLayoutBounds().getWidth() / DonneesPlateau.largeurInitialePlateau;
            }
        });
    }

}
