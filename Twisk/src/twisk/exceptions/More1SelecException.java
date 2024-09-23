package twisk.exceptions;

import javafx.animation.PauseTransition;
import javafx.scene.control.Alert;
import javafx.util.Duration;

public class More1SelecException extends TwiskException{

    public More1SelecException(){
        super();
        Alert a = new Alert(Alert.AlertType.ERROR, "Renommer est impossible (Vous avez choissi plus d'une activité !");
        a.setTitle("Error etape rename");
        a.show();
        PauseTransition ps = new PauseTransition(Duration.seconds(5));
        ps.playFromStart();
        ps.setOnFinished(e -> a.close());
    }
}
