package twisk.vues;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

public class EcouteurQuitter implements EventHandler<ActionEvent> {

    private MondeIG md;

    public EcouteurQuitter(MondeIG md){
        this.md = md;
    }

    @Override
    public void handle(ActionEvent event) {
        Platform.exit();
    }
}
