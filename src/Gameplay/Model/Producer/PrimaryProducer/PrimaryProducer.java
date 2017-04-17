package Gameplay.Model.Producer.PrimaryProducer;

import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Producer.Producer;
import Gameplay.Model.Producer.ProducerRequest;

/**
 * Created by Willie on 4/15/2017.
 */
public abstract class PrimaryProducer extends Producer {

    public void produce(){
        getGoodsBag().add(generateOutput());
    }

    public abstract GoodsBag generateOutput();
}
