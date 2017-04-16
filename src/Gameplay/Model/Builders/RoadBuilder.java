package Gameplay.Model.Builders;

import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Goods.Stone;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Region.RegionSet;


public class RoadBuilder {
    ProducerRequest input;

    public RoadBuilder(){
        generateInput();
    }

    private ProducerRequest generateInput(){
        GoodsBag inGoods = new GoodsBag();

        inGoods.addStone(new Stone());

        ProducerRequest in = new ProducerRequest(inGoods, null);

        return in;
    }

    public boolean buildRoad(UserRequest ur, Region r1, Region r2){
        if(!r1.connectsToByLand(r2)){
            return false;
        }

        if(produce(ur)) {
            buildRoad(r1.getRegionSet(), r2);
            buildRoad(r2.getRegionSet(), r1);
            return true;
        }

        return false;
    }

    private void buildRoad(RegionSet r1, Region r2) {
        r1.removeLandRegion(r2);
        r1.addRoadRegion(r2);
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
