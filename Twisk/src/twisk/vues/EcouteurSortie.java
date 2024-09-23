package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class EcouteurSortie implements EventHandler<ActionEvent> {

    private MondeIG md;

    public EcouteurSortie(MondeIG md){
        this.md = md;
    }

    @Override
    public void handle(ActionEvent event) {
        for(EtapeIG e : this.md){
            if(e.getEtapeSelec()){
                if(e.isSortie()){
                    this.md.removeEtape(e);
                }else{
                    e.setSortie(true);
                    e.setEntree(false);
                }
            }
            this.md.getSo().notifierObservateurs();
        }
    }
}
