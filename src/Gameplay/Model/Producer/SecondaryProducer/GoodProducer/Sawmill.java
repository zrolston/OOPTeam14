package Gameplay.Model.Producer.SecondaryProducer.GoodProducer;

import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.SecondaryProducer.SecondaryProducer;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Visitors.ProducerVisitor;

/**
 * Created by Willie on 4/15/2017.
 */
public class Sawmill extends SecondaryProducer {
    @Override
    public void accept(ProducerVisitor pv) {
        pv.visitSawmill(this);
    }

    @Override
    public ProducerRequest produce(UserRequest ur) {
        return null;
    }
}
