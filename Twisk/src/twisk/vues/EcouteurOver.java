package twisk.vues;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import twisk.mondeIG.MondeIG;

public class EcouteurOver implements EventHandler<DragEvent> {

    private MondeIG md;
    private VueMondeIG vM;

    public EcouteurOver(VueMondeIG vM, MondeIG md){
        this.md = md;
        this.vM = vM;
    }

    @Override
    public void handle(DragEvent event) {
        if(event.getDragboard().hasString()){
            event.acceptTransferModes(TransferMode.MOVE);
        }
        event.consume();
    }
}
