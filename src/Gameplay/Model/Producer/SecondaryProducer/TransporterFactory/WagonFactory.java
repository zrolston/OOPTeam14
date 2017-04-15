package Gameplay.Model.Producer.SecondaryProducer.TransporterFactory;

import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.SecondaryProducer.SecondaryProducer;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Visitors.ProducerVisitor;

/**
 * Created by Willie on 4/15/2017.
 */
public class WagonFactory extends SecondaryProducer {
    @Override
    public void accept(ProducerVisitor pv) {
        pv.visitWagonFactory(this);
    }

    @Override
    public ProducerRequest produce(UserRequest ur) {
        return null;
    }
}
