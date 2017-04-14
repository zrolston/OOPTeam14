package Gameplay.Model.Transporters;

import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Region.Region;

import java.util.List;

abstract public class Transporter {
    private List<Permit> permitList;
    private int capacity;
    private int movement;
    private GoodsBag carriedGoods;
    private List<Region> movementList;
    //private TransporterMovementObserver transporterMovementObserver;

    public Transporter(Permit ... permits){
        for (Permit permit : permits) {
            permitList.add(permit);
        }
    }

    public void addRegion(Region region){
        movementList.add(region);
    }

    public List<Region> getMovementList(){
        return movementList;
    }

}
