package Gameplay.Model.Map;

import Gameplay.Model.Producer.PrimaryProducer.PrimaryProducer;
import Gameplay.Model.Region.Region;
import MapBuilder.Model.ModelFacade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zrgam_000 on 4/15/2017.
 */
public class PrimaryProducerHandler {
    Map<Region, PrimaryProducer> occupancyMap;

    public PrimaryProducerHandler(){
        occupancyMap = new HashMap<>();
    }

    public void place(PrimaryProducer producer, Region region){
        occupancyMap.put(region, producer);
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
}
