package Gameplay.Model.BuildAbilities.PlayerSpecific;

import Gameplay.Model.BuildAbilities.BuildAbility;
import Gameplay.Model.Goods.Board;
import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Goods.Stone;
import Gameplay.Model.Map.GoodsHandler;
import Gameplay.Model.Map.PrimaryProducerHandler;
import Gameplay.Model.Producer.PrimaryProducer.OilRig;
import Gameplay.Model.Producer.PrimaryProducer.WoodCutter;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Utility.PlayerID;

/**
 * Created by zrgam_000 on 4/16/2017.
 */
public class BuildOilRig extends BuildAbility{
    PrimaryProducerHandler primaryProducerHandler;
    GoodsHandler goodsHandler;

    public BuildOilRig(PlayerID id) {

        super(id);

        GoodsBag goods = new GoodsBag();
        goods.addBoard(new Board());
        goods.addBoard(new Board());
        goods.addBoard(new Board());
        goods.addStone(new Stone());

        input = new ProducerRequest(goods, null);
    }

    @Override
    public void build(UserRequest ur, Region region) {
        if(!ur.contains(getInput())){
            return;
        }
        ur.removeUsed(input);
        ur.reset();

        goodsHandler.place(new GoodsBag(), region);

        primaryProducerHandler.place(new OilRig(), region);
    }
}
