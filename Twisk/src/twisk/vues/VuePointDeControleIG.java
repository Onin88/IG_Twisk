package twisk.vues;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

public class VuePointDeControleIG extends Circle {

    private MondeIG md;
    private PointDeControleIG pd;

    public VuePointDeControleIG(MondeIG monde, PointDeControleIG pd) {
        this.md = monde;
        this.pd = pd;
        this.setCenterX(this.pd.getPosX());
        this.setCenterY(this.pd.getPosY());
        this.setFill(Paint.valueOf("FFC0CB"));
        this.setRadius(5);
        this.setOnMouseClicked(new EcouteurPointDeControle(this.md, this.pd));
    }
}
