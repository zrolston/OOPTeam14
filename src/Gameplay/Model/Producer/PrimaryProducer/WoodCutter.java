package Gameplay.Model.Producer.PrimaryProducer;

import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Goods.Trunk;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Visitors.ProducerVisitor;

/**
 * Created by Willie on 4/15/2017.
 */
public class WoodCutter extends PrimaryProducer {

    public WoodCutter(GoodsBag goodsBag) {
        super(goodsBag);
    }

    @Override
    public void accept(ProducerVisitor pv) {
        pv.visitWoodCutter(this);
    }

    @Override
    public GoodsBag generateOutput() {
        GoodsBag goods = new GoodsBag();
        goods.addTrunk(new Trunk());
        return goods;
    }
}
