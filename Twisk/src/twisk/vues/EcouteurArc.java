package twisk.vues;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.MondeIG;

public class EcouteurArc implements EventHandler<MouseEvent> {

    private MondeIG md;
    private ArcIG arc;


    public EcouteurArc(MondeIG monde, ArcIG arc){
        this.md = monde;
        this.arc = arc;
    }


    @Override
    public void handle(MouseEvent event) {
        if(this.arc.getIsSelect() == true){
            this.arc.setIsSelect(false);
        }else{
            this.arc.setIsSelect(true);
        }
        this.md.getSo().notifierObservateurs();
    }
}
