package Gameplay.Model.Map;

import Gameplay.Model.Producer.PrimaryProducer.PrimaryProducer;
import Gameplay.Model.Producer.SecondaryProducer.GoodProducer.SecondaryGoodFactory;
import Gameplay.Model.Producer.SecondaryProducer.TransporterFactory.SecondaryTransporterFactory;
import Gameplay.Model.Region.Region;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zrgam_000 on 4/15/2017.
 */
public class SecondaryProducerHandler {
    Map<Region, SecondaryGoodFactory> goodOccupancyMap;
    Map<Region, SecondaryTransporterFactory> factoryOccupancyMap;

    public SecondaryProducerHandler(){
        goodOccupancyMap = new HashMap<>();
        factoryOccupancyMap = new HashMap<>();
    }

    public void placeGoodsProducer(SecondaryGoodFactory producer, Region region){
        goodOccupancyMap.put(region, producer);
    }

    public void placeTransporterProducer(SecondaryTransporterFactory producer, Region region){
        factoryOccupancyMap.put(region, producer);
    }

    public SecondaryGoodFactory getSecondaryProducerAt(Region r){

        SecondaryGoodFactory producer = goodOccupancyMap.get(r);

        return producer;
    }

    public SecondaryTransporterFactory getTransporterProducerAt(Region r){

        SecondaryTransporterFactory producer = factoryOccupancyMap.get(r);

        return producer;
    }
}
