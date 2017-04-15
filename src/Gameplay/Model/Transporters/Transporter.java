package Gameplay.Model.Transporters;

import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Goods.LimitedGoodsBag;
import Gameplay.Model.Tile.Region;
import Gameplay.Model.Tile.RegionSet;

import java.util.List;

abstract public class Transporter {
    private List<Permit> permitList;
    private int capacity;
    private int movement;
    private LimitedGoodsBag goods;
    private List<Region> movementList;
    //private TransporterMovementObserver transporterMovementObserver;

    public Transporter(Permit ... permits){
        for (Permit permit : permits) {
            permitList.add(permit);
        }
    }

    void addRegion(Region region){
        movementList.add(region);
    }

    public List<Region> getMovementList(){
        return movementList;
    }

    public void updateMovementSet(RegionSet regionSet){
        movementList.clear();
        for (Permit permit : permitList) {
            permit.findRegions(regionSet, this);
        }
    }

}
