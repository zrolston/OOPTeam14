package Gameplay.Model.Transporters;

import Gameplay.Model.Region.Region;
import Gameplay.Model.Region.RegionSet;
import Gameplay.Model.TransporterFactory.Permit;
import Gameplay.Model.Goods.LimitedGoodsBag;
import Gameplay.Model.Utility.Owned;
import Gameplay.Model.Utility.PlayerID;
import Gameplay.Model.Visitors.Carriable;
import Gameplay.Model.Visitors.TransporterVisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract public class Transporter extends Owned implements Carriable{
    private List<Permit> permitList;
    private int capacity;
    private int maxMovement;
    private int remainingMovement;
    private LimitedGoodsBag goods;
    private Map<Region, Integer> movementList;
    private Region[] cache; //Current = cache[0], cached = cache[1]
    //private TransporterMovementObserver transporterMovementObserver;

    public Transporter(Permit ... permits){
        cache = new Region[2];
        permitList = new ArrayList<>();
        movementList = new HashMap<>();
        for (Permit permit : permits) {
            permitList.add(permit);
        }
    }

    public void addRegion(Region region, int cost){
        movementList.put(region, cost);
    }

    public Map<Region, Integer> getMovementList(){
        return movementList;
    }

    public void updateMovementSet(RegionSet regionSet){
        for (Permit permit : permitList) {
            permit.findRegions(regionSet, this);
        }
    }

    public abstract void accept(TransporterVisitor tv);

    public void setCurrentRegion(Region region){
        cache[1] = cache[0];
        cache[0] = region;
    }

    public Region getCachedRegion(){
        return cache[1];
    }

    protected void setMaxMovement(int n){
        this.maxMovement = n;
    }

    public boolean moveTo(Region region){
        if (movementList.containsValue(region) && movementList.get(region) <= remainingMovement){
            region.enterRegion(this);
            remainingMovement -= movementList.get(region);
            return true;
        }
        return false;
    }

    public void resetMovement(){
        remainingMovement = maxMovement;
    }

}
