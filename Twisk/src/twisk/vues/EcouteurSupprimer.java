package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class EcouteurSupprimer implements EventHandler<ActionEvent> {

    private MondeIG md;

    public EcouteurSupprimer(MondeIG md){
        this.md = md;
    }

    @Override
    public void handle(ActionEvent event) {
        this.md.remove();
        this.md.removeArc();
        this.md.getSo().notifierObservateurs();
    }
}
