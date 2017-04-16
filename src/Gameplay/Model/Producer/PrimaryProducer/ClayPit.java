package Gameplay.Model.Producer.PrimaryProducer;

import Gameplay.Model.Goods.Clay;
import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Visitors.ProducerVisitor;

/**
 * Created by Willie on 4/15/2017.
 */
public class ClayPit extends PrimaryProducer {

    @Override
    public void accept(ProducerVisitor pv) {
        pv.visitClayPit(this);
    }



    @Override
    public GoodsBag produce() {
        GoodsBag goods = new GoodsBag();
        goods.addClay(new Clay());
        return goods;
    }
}
