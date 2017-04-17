package Gameplay.Model.BuildAbilities.Neutral;

import Gameplay.Model.BuildAbilities.BuildAbility;
import Gameplay.Model.Goods.Board;
import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Goods.Stone;
import Gameplay.Model.Map.SecondaryProducerHandler;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.SecondaryProducer.GoodProducer.CoalBurner;
import Gameplay.Model.Producer.SecondaryProducer.GoodProducer.Mint;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Utility.PlayerID;
import Gameplay.Model.Visitors.BuildAbilityVisitor;


public class BuildMint extends BuildAbility {

    SecondaryProducerHandler secondaryProducerHandler;

    public BuildMint(PlayerID id) {

        super(id);

        GoodsBag goods = new GoodsBag();
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

        secondaryProducerHandler.placeGoodsProducer(new Mint(), region);
    }

    @Override
    public void accept(BuildAbilityVisitor bav) {
        bav.visitBuildMint(this);
    }

}
