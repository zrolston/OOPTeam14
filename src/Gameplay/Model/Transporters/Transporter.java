package Gameplay.Model.Transporters;

import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Region.RegionSet;
import Gameplay.Model.TransporterFactory.Permit;

import java.util.ArrayList;
import java.util.List;

abstract public class Transporter {
    private List<Permit> permitList;
    private int capacity;
    private int movement;
    private GoodsBag carriedGoods;
    private List<Region> movementList;
    //private TransporterMovementObserver transporterMovementObserver;

    public Transporter(Permit ... permits){
        permitList = new ArrayList<>();
        movementList = new ArrayList<>();
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

    public void updateMovementSet(RegionSet regionSet){
        movementList.clear();
        for (Permit permit : permitList) {
            permit.findRegions(regionSet, this);
        }
    }

}
