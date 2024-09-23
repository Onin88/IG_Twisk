package twisk.exceptions;

import javafx.animation.PauseTransition;
import javafx.scene.control.Alert;
import javafx.util.Duration;

public class ArcException extends TwiskException {

    public ArcException(){
        super();
        Alert a = new Alert(Alert.AlertType.ERROR, "La création de l'arc est impossible !");
        a.setTitle("Error arc creation");
        a.show();
        PauseTransition ps = new PauseTransition(Duration.seconds(2));
        ps.playFromStart();
        ps.setOnFinished(e -> a.close());

    }
}
