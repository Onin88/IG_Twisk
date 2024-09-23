package twisk.vues;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class EcouteurEtape implements EventHandler<MouseEvent> {

    private MondeIG md;
    private EtapeIG e;

    public EcouteurEtape(MondeIG monde, EtapeIG ep){
        this.md = monde;
        this.e = ep;
    }

    @Override
    public void handle(MouseEvent event) {
        if(this.e.getEtapeSelec() == true){
            this.e.setEtapeSelec(false);
        }else{
            this.e.setEtapeSelec(true);
            this.md.setEtapeSelec(this.e);
        }
        this.md.getSo().notifierObservateurs();
    }
}
