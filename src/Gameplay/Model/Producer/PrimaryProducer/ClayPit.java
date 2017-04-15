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

    }

    @Override
    public ProducerRequest produce() {
        GoodsBag goods = new GoodsBag();
        goods.addClay(new Clay());
        return new ProducerRequest(goods, null);
    }
}
