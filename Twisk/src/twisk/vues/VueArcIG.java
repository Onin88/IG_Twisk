package twisk.vues;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import twisk.mondeIG.*;

public class VueArcIG extends Pane {

    private MondeIG md;
    private ArcIG arc;
    private Line line;
    private Polyline triangle;

    public VueArcIG(MondeIG monde, ArcIG arc) {
        this.md = monde;
        this.arc = arc;

        this.line = new Line(this.arc.getPt1().getPosX(), this.arc.getPt1().getPosY(), this.arc.getPt2().getPosX(), this.arc.getPt2().getPosY());
        this.line.setStrokeWidth(3);
        this.line.setStroke(Paint.valueOf("#FBEDC9"));

        double angle = Math.atan2(this.arc.getPt2().getPosY() - this.arc.getPt1().getPosY(), this.arc.getPt2().getPosX() - this.arc.getPt1().getPosX()) - Math.PI / 2.0;
        double cos = Math.sin(angle);
        double sin = Math.cos(angle);

        this.triangle = new Polyline(this.arc.getPt2().getPosX(), this.arc.getPt2().getPosY(),
                (-1 / 2 * cos + Math.sqrt(3) / 2 * sin) * 8 + this.arc.getPt2().getPosX(),
                (-1 / 2 * sin - Math.sqrt(3) / 2 * cos) * 8 + this.arc.getPt2().getPosY(),
                (1 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * 8 + this.arc.getPt2().getPosX(),
                (1 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * 8 + this.arc.getPt2().getPosY(),
                this.arc.getPt2().getPosX(), this.arc.getPt2().getPosY());

        this.triangle.setStrokeWidth(5);
        this.triangle.setStroke(Paint.valueOf("#F8DDA9"));

        this.getChildren().add(this.line);
        this.getChildren().add(this.triangle);

        this.line.setOnMouseClicked(new EcouteurArc(this.md, this.arc));

        if(this.arc.getIsSelect() == true){
            this.line.setStroke(Paint.valueOf("FF6961"));
        }
    }
}
