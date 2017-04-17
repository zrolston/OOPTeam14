package Gameplay.Model.Map;

import Gameplay.Model.Producer.PrimaryProducer.PrimaryProducer;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Tile.GameTile;
import MapBuilder.Model.ModelFacade;

import java.util.*;

/**
 * Created by zrgam_000 on 4/15/2017.
 */
public class PrimaryProducerHandler {
    Map<Region, PrimaryProducer> occupancyMap;

    GoodsHandler goodsHandler;

    public PrimaryProducerHandler(){
        occupancyMap = new HashMap<>();
    }

    public void place(PrimaryProducer producer, Region region){

        occupancyMap.put(region, producer);
        producer.setGoodsBag(goodsHandler.getGoodsBagAt(region));
        clearRegionsAt(region.getParentTile());
    }

    public PrimaryProducer getPrimaryProducerAt(Region r){

        PrimaryProducer primaryProducer = occupancyMap.get(r);

        return primaryProducer;
    }
    
    public List<Region> getBuiltRegions(){
        List<Region> regions = new ArrayList<>();
        
        regions.addAll(occupancyMap.keySet());
        
        return regions;
    }

    private void clearRegionsAt(GameTile tile){
        Iterator<Region> myRegions = tile.getMyRegions();
        while(myRegions.hasNext()){
            myRegions.next().clearAbilities();
        }
    }
}
