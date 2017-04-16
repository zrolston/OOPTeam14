package Gameplay.Model.Map;

import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Goods.LimitedGoodsBag;
import Gameplay.Model.Region.Region;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zrgam_000 on 4/15/2017.
 */
public class GoodsHandler {
    Map<Region, GoodsBag> occupancyMap;

    public GoodsHandler(){
        occupancyMap = new HashMap<>();
    }

    public void place(GoodsBag goodsBag, Region region){
        occupancyMap.put(region, goodsBag);
    }

    public GoodsBag getGoodsBagAt(Region r){

        GoodsBag goodsBag = occupancyMap.get(r);

        if(goodsBag == null){
            goodsBag = new LimitedGoodsBag(0);
        }

        return goodsBag;
    }
}
