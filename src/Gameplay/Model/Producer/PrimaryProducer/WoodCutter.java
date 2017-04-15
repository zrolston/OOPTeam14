package Gameplay.Model.Producer.PrimaryProducer;

import Gameplay.Model.Visitors.ProducerVisitor;

/**
 * Created by Willie on 4/15/2017.
 */
public class WoodCutter extends PrimaryProducer {

    @Override
    public void accept(ProducerVisitor pv) {
        pv.visitWoodCutter(this);
    }

    @Override
    public void produce() {

    }
}
