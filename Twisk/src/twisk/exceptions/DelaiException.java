package twisk.exceptions;

import javafx.animation.PauseTransition;
import javafx.scene.control.Alert;
import javafx.util.Duration;

public class DelaiException extends TwiskException{

    public DelaiException(){
        super();
        Alert a = new Alert(Alert.AlertType.ERROR, "Le changement de délai est impossible (votre délai est en dehors des bornes [0-99] !");
        a.setTitle("Error delai changing");
        a.show();
        PauseTransition ps = new PauseTransition(Duration.seconds(5));
        ps.playFromStart();
        ps.setOnFinished(e -> a.close());
    }
}
