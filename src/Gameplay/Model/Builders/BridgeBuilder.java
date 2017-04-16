package Gameplay.Model.Builders;

import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Goods.Stone;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Region.RegionSet;
import Gameplay.Model.Tile.RegionMap;

/**
 * Created by zrgam_000 on 4/15/2017.
 */
public class BridgeBuilder {
    ProducerRequest input;

    public BridgeBuilder(){
        generateInput();
    }

    private ProducerRequest generateInput(){
        GoodsBag inGoods = new GoodsBag();

        inGoods.addStone(new Stone());

        ProducerRequest in = new ProducerRequest(inGoods, null);

        return in;
    }

    public boolean buildBridge(UserRequest ur, RegionMap regionMap, Region r1, Region r2){
        if(regionMap.contains(r1) && regionMap.contains(r2)){
            if(produce(ur)) {
                buildBridge(r1.getRegionSet(), r2);
                buildBridge(r2.getRegionSet(), r1);
                return true;
            }
        }

        return false;
    }

    private void buildBridge(RegionSet r1, Region r2) {
        r1.addBridgeRegion(r2);
    }

    private boolean produce(UserRequest ur) {
        if (!ur.contains(input))
            return false;
        else {
            ur.removeUsed(input);
            ur.reset();
            return true;
        }
    }
}
