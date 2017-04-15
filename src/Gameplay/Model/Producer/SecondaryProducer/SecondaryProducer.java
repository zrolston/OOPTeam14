package Gameplay.Model.Producer.SecondaryProducer;

import Gameplay.Model.Producer.Producer;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.UserRequest;

/**
 * Created by Willie on 4/15/2017.
 */
public abstract class SecondaryProducer extends Producer {
    public abstract ProducerRequest produce(UserRequest ur);
}
