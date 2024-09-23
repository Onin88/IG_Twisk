package twisk.vues;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.*;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import twisk.mondeIG.*;


public class VueOutils extends TilePane implements Observateur {

    private MondeIG md;
    private Button bt;

    public VueOutils(MondeIG monde){
        this.md = monde;
        bt = new Button("ADD ACTIVITY");
        bt.setOnAction(new EcouteurBouton(this.md));
        ImageView img = new ImageView(new Image(getClass().getResourceAsStream("../ressources/images/ButtonAdd.png")));
        bt.setGraphic(img);
        Tooltip tp = new Tooltip("Bouton qui permet d'ajouter une activité");
        bt.setTooltip(tp);
        bt.getTooltip().setShowDelay(Duration.ZERO);
        bt.setStyle("-fx-border-color: Black; -fx-background-color: CFA0E9; -fx-border-radius: 5");

        img.setFitHeight(25);
        img.setFitWidth(25);

        this.getChildren().add(bt);
        this.setAlignment(Pos.BOTTOM_RIGHT);

    }

    public void reagir(){
    }
}
