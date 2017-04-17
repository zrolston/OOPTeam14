package Gameplay.Model.Producer.PrimaryProducer;

import Gameplay.Model.Goods.Fuel;
import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Visitors.ProducerVisitor;

/**
 * Created by Willie on 4/15/2017.
 */
public class OilRig extends PrimaryProducer {

    public OilRig(GoodsBag goodsBag) {
        super(goodsBag);
    }

    @Override
    public void accept(ProducerVisitor pv) {
        pv.visitOilRig(this);
    }

    @Override
    public GoodsBag generateOutput() {
        GoodsBag goods = new GoodsBag();
        goods.addFuel(new Fuel());
        return goods;
    }
}
