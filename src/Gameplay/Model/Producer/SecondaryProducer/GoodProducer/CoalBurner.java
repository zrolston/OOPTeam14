package Gameplay.Model.Producer.SecondaryProducer.GoodProducer;

import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.SecondaryProducer.SecondaryProducer;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Visitors.ProducerVisitor;

/**
 * Created by Willie on 4/15/2017.
 */
public class CoalBurner extends SecondaryProducer {
    @Override
    public void accept(ProducerVisitor pv) {
        pv.visitCoalBurner(this);
    }

    @Override
    public ProducerRequest produce(UserRequest ur) {
        return null;
    }
}
