package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.*;

public class EcouteurBouton implements EventHandler<ActionEvent> {

    private MondeIG md;

    public EcouteurBouton(MondeIG md){
        this.md = md;
    }

    @Override
    public void handle(ActionEvent event){
        this.md.ajouter("Activité");
        this.md.getSo().notifierObservateurs();
    }
}
