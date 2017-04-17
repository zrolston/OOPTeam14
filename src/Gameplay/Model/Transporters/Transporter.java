package Gameplay.Model.Transporters;

import Gameplay.Model.Goods.Good;
import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Region.RegionSet;
import Gameplay.Model.TransporterFactory.Permit;
import Gameplay.Model.Goods.LimitedGoodsBag;
import Gameplay.Model.Utility.Owned;
import Gameplay.Model.Utility.PlayerID;
import Gameplay.Model.Visitors.*;

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
    private Transporter carriedTransporter;
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

    public void accept(GenericCarriableVisitor gnv){
        gnv.visitTransporter(this);
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
        this.remainingMovement = n;
    }

    public boolean moveTo(Region region){
        if (movementList.containsKey(region) && movementList.get(region) <= remainingMovement){
            region.enterRegion(this);
            remainingMovement -= movementList.get(region);
            return true;
        }
        return false;
    }

    public void resetMovement(){
        remainingMovement = maxMovement;
    }

    public ArrayList<Carriable> getCarriables() {
        ArrayList<Carriable> myShit = new ArrayList<>();

        if(carriedTransporter != null) {
            myShit.add(carriedTransporter);
        }

        else{
            myShit.addAll(goods.getGoods());
        }

        return myShit;
    }

    public GoodsBag getGoodsBag() {
        return goods;
    }

    public void dropTransporter() {
        this.carriedTransporter = null;
    }

    public void pickUpGood(Good good) {
        goods.addGood(good);
    }

    public void dropGood(Good good) {
        goods.removeGood(good);
    }

    public void pickUpTransporter(Transporter transporter) {
        this.carriedTransporter = transporter;
    }

    public Region getCurrentRegion() {
        return cache[0];
    }
}
