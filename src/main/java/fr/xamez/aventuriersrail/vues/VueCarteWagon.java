package fr.xamez.aventuriersrail.vues;

import fr.xamez.aventuriersrail.ICouleurWagon;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Cette classe représente la vue d'une carte Wagon.
 *
 * On y définit le listener à exécuter lorsque cette carte a été choisie par l'utilisateur
 */
public class VueCarteWagon extends Pane {

    private final ICouleurWagon couleurWagon;

    public VueCarteWagon(ICouleurWagon couleurWagon, int nombre) {
        this.couleurWagon = couleurWagon;
        Image image = new Image(getClass().getClassLoader().getResource("images/cartes/wagons/carte-wagon-" + couleurWagon.toString().toUpperCase() + ".png").toString());
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(130);
        getChildren().add(imageView);
        if (nombre > 0) {
            imageView.setTranslateY(25);
            imageView.setRotate(90);
            imageView.setFitWidth(110);
            Circle circle = new Circle(15, Color.WHITE);
            circle.setCenterX(imageView.getFitWidth() - 30);
            circle.setCenterY(10);
            circle.setEffect(new DropShadow(10, Color.BLACK));
            Label nombreLabel = new Label(Integer.toString(nombre));
            nombreLabel.setStyle("-fx-font-size: 15px; -fx-font-weight: bold;");
            nombreLabel.relocate(imageView.getFitWidth() - 35,  0);
            nombreLabel.setAlignment(Pos.TOP_RIGHT);
            getChildren().addAll(circle, nombreLabel);
        }
    }

    public ICouleurWagon getCouleurWagon() {
        return couleurWagon;
    }

}
