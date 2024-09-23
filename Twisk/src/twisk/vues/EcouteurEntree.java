package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class EcouteurEntree implements EventHandler<ActionEvent> {

    private MondeIG md;

    public EcouteurEntree(MondeIG md){
        this.md = md;
    }

    @Override
    public void handle(ActionEvent event) {
        for(EtapeIG e : this.md){
            if(e.getEtapeSelec()){
                if(e.isEntree()){
                    this.md.removeEtape(e);
                }else{
                    e.setEntree(true);
                    e.setSortie(false);
                }
            }
            this.md.getSo().notifierObservateurs();
        }
    }
}
