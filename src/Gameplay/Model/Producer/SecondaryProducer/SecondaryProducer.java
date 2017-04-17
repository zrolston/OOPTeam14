package Gameplay.Model.Producer.SecondaryProducer;

import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Producer.Producer;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.UserRequest;

import java.util.List;

public abstract class SecondaryProducer extends Producer {

    private List<ProducerRequest> inputs;
    private int maxCapacity;
    private int currentCapacity;

    public void setMaxCapacity(int i){
        maxCapacity = i;
        currentCapacity = i;
    }

    public abstract void produce(UserRequest userRequest);

    public void doUntilFull(){
        UserRequest ur = new UserRequest();
        ur.addGoods(getGoodsBag(), getGoodsBag());

        while (containsAny(ur, inputs) && currentCapacity > 0){
            produce(ur);
        }
    }

    private boolean containsAny(UserRequest ur, List<ProducerRequest> inputs){
        for(ProducerRequest pr : inputs){
            if(ur.contains(pr)){
                return true;
            }
        }
        return false;
    }

    public int getCapacity(){
        return currentCapacity;
    }

    public void reduceCapacity(){
        currentCapacity--;
    }

    public List<ProducerRequest> getInputs() {
        return inputs;
    }
}
