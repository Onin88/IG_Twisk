package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.util.Iterator;

public class EcouteurEffacer implements EventHandler<ActionEvent> {

    private MondeIG md;

    public EcouteurEffacer(MondeIG monde){
        this.md = monde;
    }

    @Override
    public void handle(ActionEvent event) {
        for(EtapeIG e : this.md){
            e.setEtapeSelec(false);
        }
        for(Iterator<ArcIG> iter = this.md.iterArc(); iter.hasNext();){
            iter.next().setIsSelect(false);
        }
        this.md.getSo().notifierObservateurs();
    }
}
