package Gameplay.Model.Producer.SecondaryProducer.GoodProducer;

import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Producer.Producer;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.UserRequest;

/**
 * Created by Willie on 4/15/2017.
 */
public abstract class SecondaryGoodFactory extends Producer {
    public abstract GoodsBag produce(UserRequest ur);
}
