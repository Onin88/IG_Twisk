package twisk.vues;

import javafx.scene.layout.Pane;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class VueMondeIG extends Pane implements Observateur{

    private MondeIG md;

    public VueMondeIG(MondeIG monde){
        this.md = monde;
        this.md.getSo().addObservateur(this);
        for(EtapeIG etape : this.md) {
            this.getChildren().add(new VueActiviteIG(this.md, etape));
            for(PointDeControleIG pd : etape){
                this.getChildren().add(new VuePointDeControleIG(this.md, pd));
            }
        }
        this.setOnDragOver(new EcouteurOver(this, this.md));
        this.setOnDragDropped(new EcouteurDropped(this.md, this));
    }

    public void reagir(){
        this.getChildren().clear();

        for(Iterator<ArcIG> iter = this.md.iterArc(); iter.hasNext();){
            this.getChildren().add(new VueArcIG(this.md, iter.next()));
        }

        for(EtapeIG etape : this.md) {
            this.getChildren().add(new VueActiviteIG(this.md, etape));
            for(PointDeControleIG pd : etape){
                this.getChildren().add(new VuePointDeControleIG(this.md, pd));
            }
            System.out.println(etape.toString());
        }
    }
}
