package Gameplay.Model.Map;

import Gameplay.Model.Producer.SecondaryProducer.GoodProducer.SecondaryGoodProducer;
import Gameplay.Model.Producer.SecondaryProducer.TransporterProducer.SecondaryTransporterProducer;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Tile.GameTile;

import java.util.*;

/**
 * Created by zrgam_000 on 4/15/2017.
 */
public class SecondaryProducerHandler {
    Map<Region, SecondaryGoodProducer> goodOccupancyMap;
    Map<Region, SecondaryTransporterProducer> factoryOccupancyMap;

    GoodsHandler goodsHandler;

    public SecondaryProducerHandler(){
        goodOccupancyMap = new HashMap<>();
        factoryOccupancyMap = new HashMap<>();
    }

    public void placeGoodsProducer(SecondaryGoodProducer producer, Region region){
        goodOccupancyMap.put(region, producer);
        producer.setGoodsBag(goodsHandler.getGoodsBagAt(region));
        clearRegionsAt(region.getParentTile());
    }

    public void placeTransporterProducer(SecondaryTransporterProducer producer, Region region){
        factoryOccupancyMap.put(region, producer);
        producer.setGoodsBag(goodsHandler.getGoodsBagAt(region));
        clearRegionsAt(region.getParentTile());
    }

    public SecondaryGoodProducer getSecondaryProducerAt(Region r){

        SecondaryGoodProducer producer = goodOccupancyMap.get(r);

        return producer;
    }

    public SecondaryTransporterProducer getTransporterProducerAt(Region r){

        SecondaryTransporterProducer producer = factoryOccupancyMap.get(r);

        return producer;
    }

    public List<Region> getBuiltRegions(){
        List<Region> regions = new ArrayList<>();

        regions.addAll(factoryOccupancyMap.keySet());

        return regions;
    }

    private void clearRegionsAt(GameTile tile){
        Iterator<Region> myRegions = tile.getMyRegions();
        while(myRegions.hasNext()){
            myRegions.next().clearAbilities();
        }
    }

    public void produce() {
        for(SecondaryGoodProducer secondaryGoodProducer : goodOccupancyMap.values()){
            secondaryGoodProducer.doUntilFull();
        }
    }

    public void reset(){
        for(SecondaryTransporterProducer secondaryTransporterProducer : factoryOccupancyMap.values()){
            secondaryTransporterProducer.resetCapacity();
        }
        for(SecondaryGoodProducer secondaryGoodProducer : goodOccupancyMap.values()){
            secondaryGoodProducer.resetCapacity();
        }
    }
}
