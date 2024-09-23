package twisk.vues;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import twisk.mondeIG.MondeIG;

public class EcouteurDropped implements EventHandler<DragEvent> {

    private MondeIG md;
    private VueMondeIG vM;

    public EcouteurDropped(MondeIG md, VueMondeIG vM){
        this.md = md;
        this.vM = vM;
    }

    @Override
    public void handle(DragEvent event) {
        Dragboard d = event.getDragboard();
        if(d.hasString()){
            this.md.dragNDrop(d.getString(), (int) event.getSceneX(), (int) event.getSceneY());
            event.setDropCompleted(true);
            this.md.getSo().notifierObservateurs();
        }
        event.consume();
    }
}
