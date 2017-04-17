package Gameplay.Model.BuildAbilities.Neutral;

import Gameplay.Model.BuildAbilities.BuildAbility;
import Gameplay.Model.Goods.Board;
import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Goods.Stone;
import Gameplay.Model.Map.SecondaryProducerHandler;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.SecondaryProducer.GoodProducer.StoneFactory;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Utility.PlayerID;
import Gameplay.Model.Visitors.BuildAbilityVisitor;

/**
 * Created by zrgam_000 on 4/16/2017.
 */
public class BuildStockMarket extends BuildAbility{
    SecondaryProducerHandler secondaryProducerHandler;

    public BuildStockMarket(PlayerID id) {

        super(id);

        GoodsBag goods = new GoodsBag();
        goods.addStone(new Stone());
        goods.addStone(new Stone());
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

        secondaryProducerHandler.placeGoodsProducer(new StoneFactory(), region);
    }

    @Override
    public void accept(BuildAbilityVisitor bav) {
        bav.visitBuildStockMarket(this);
    }
}
