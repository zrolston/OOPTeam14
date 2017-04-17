package Gameplay.Model.Producer.PrimaryProducer;

import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Goods.Stone;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Visitors.ProducerVisitor;

/**
 * Created by Willie on 4/15/2017.
 */
public class StoneQuarry extends PrimaryProducer {

    public StoneQuarry(GoodsBag goodsBag) {
        super(goodsBag);
    }

    @Override
    public void accept(ProducerVisitor pv) {
        pv.visitStoneQuarry(this);
    }

    @Override
    public GoodsBag generateOutput() {
        GoodsBag goods = new GoodsBag();
        goods.addStone(new Stone());
        return goods;
    }
}
