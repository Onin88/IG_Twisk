package twisk.exceptions;

import javafx.animation.PauseTransition;
import javafx.scene.control.Alert;
import javafx.util.Duration;

public class EcartException extends TwiskException{

    public EcartException(){
        super();
        Alert a = new Alert(Alert.AlertType.ERROR, "Le changement d'écart' est impossible (votre écart doit être supérieur à votre délai ou inférieur à 0!");
        a.setTitle("Error ecart changing");
        a.show();
        PauseTransition ps = new PauseTransition(Duration.seconds(5));
        ps.playFromStart();
        ps.setOnFinished(e -> a.close());
    }
}
