package twisk.vues;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import twisk.mondeIG.*;
import twisk.outils.TailleComposants;

public class VueActiviteIG extends VueEtapeIG implements Observateur{

    private MondeIG md;
    private Label l1;
    private EtapeIG ep;

    public VueActiviteIG(MondeIG monde, EtapeIG etape){
        super(monde, etape);
        HBox hb = new HBox();
        ep = etape;
        hb.relocate(etape.getPosX(), etape.getPosY());
        hb.setStyle("-fx-border-color: #0059FF; -fx-background-insets: 0 0 -1 0, 0, 1, 2; -fx-background-radius: 3px, 3px, 2px, 1px");
        int largeur = TailleComposants.getInstance().getLargeur();
        int hauteur = TailleComposants.getInstance().getHauteur();
        hb.setPrefSize(largeur,hauteur);
        this.getChildren().add(hb);
    }

    @Override
    public void reagir() {
    }
}
