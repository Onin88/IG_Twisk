package twisk.mondeIG;

public class ArcIG {

    private PointDeControleIG pt1;
    private PointDeControleIG pt2;
    private boolean isSelect;

    public ArcIG(PointDeControleIG p, PointDeControleIG d){
        this.pt1 = p;
        this.pt2 = d;
    }

    public PointDeControleIG getPt1() {
        return pt1;
    }

    public PointDeControleIG getPt2() {
        return pt2;
    }

    public void setIsSelect(boolean bool){
        this.isSelect = bool;
    }

    public boolean getIsSelect(){
        return this.isSelect;
    }
}
