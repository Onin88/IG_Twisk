package twisk.vues;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import twisk.mondeIG.*;
import twisk.outils.TailleComposants;

public abstract class VueEtapeIG extends VBox implements Observateur{

    private MondeIG md;
    private Label l1;
    private EtapeIG eg;

    public VueEtapeIG(MondeIG monde, EtapeIG etape){
        this.md = monde;
        this.eg = etape;

        this.l1 = new Label(eg.getNom() + " : " + eg.getDelai() + " ± " + eg.getEcart() + " temps");
        if(eg.isSortie()){
            ImageView sortie = new ImageView(new Image(getClass().getResourceAsStream("../ressources/images/exit.png")));
            sortie.setFitHeight(30);
            sortie.setFitWidth(40);
            l1.setGraphic(sortie);
        }
        if(eg.isEntree()){
            ImageView entree = new ImageView(new Image(getClass().getResourceAsStream("../ressources/images/entree.png")));
            entree.setFitHeight(25);
            entree.setFitWidth(30);
            l1.setGraphic(entree);
        }



        this.getChildren().add(l1);
        this.relocate(etape.getPosX(), etape.getPosY());
        this.setPrefSize(TailleComposants.getInstance().getLargeur(), TailleComposants.getInstance().getHauteur());
        this.setStyle("-fx-background-color: B19CD9; -fx-border-color: BLACK; -fx-border-radius: 5");
        this.setOnMouseClicked(new EcouteurEtape(this.md, this.eg));
        if(eg.getEtapeSelec() == true){
            this.setStyle("-fx-background-color: E2FCFB; -fx-border-color: red; -fx-border-width: 5; -fx-border-radius: 5");
        }
        this.setOnDragDetected(new EcouteurDrag(this,this.eg));

    }

    @Override
    public void reagir() {
    }
}
