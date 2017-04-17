package Gameplay.Model.Producer.SecondaryProducer.GoodProducer;

import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Map.SecondaryProducerHandler;
import Gameplay.Model.Producer.Producer;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.SecondaryProducer.SecondaryProducer;
import Gameplay.Model.Producer.UserRequest;

/**
 * Created by Willie on 4/15/2017.
 */
public abstract class SecondaryGoodProducer extends SecondaryProducer {

    public SecondaryGoodProducer(GoodsBag goodsBag) {
        super(goodsBag);
    }

    public void produce(UserRequest ur){
        if(getCapacity() < 0){
            return;
        }
        for (ProducerRequest pr : getInputs()) {
            if(ur.contains(pr)){
                ur.removeUsed(pr);
                GoodsBag leftover = ur.addProducedGoods(generateOutputs());
                getGoodsBag().add(leftover);
                ur.reset();
                reduceCapacity();
                return;
            }
        }
    }

    protected abstract GoodsBag generateOutputs();
}
