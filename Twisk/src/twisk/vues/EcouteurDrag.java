package twisk.vues;

import javafx.event.EventHandler;
import javafx.scene.SnapshotParameters;
import javafx.scene.input.*;
import twisk.mondeIG.EtapeIG;

public class EcouteurDrag implements EventHandler<MouseEvent> {

    private EtapeIG e;
    private VueEtapeIG vE;

    public EcouteurDrag(VueEtapeIG vE, EtapeIG e){
        this.e = e;
        this.vE = vE;
    }

    @Override
    public void handle(MouseEvent event) {
        Dragboard d = vE.startDragAndDrop(TransferMode.MOVE);
        vE.setId(e.getIdentifiant());
        ClipboardContent c = new ClipboardContent();
        c.putString(e.getIdentifiant());
        d.setDragView(vE.snapshot(new SnapshotParameters(), null));
        d.setContent(c);
        event.consume();
    }
}
