package Gameplay.Model.Producer.SecondaryProducer.GoodProducer;

import Gameplay.Model.Goods.Board;
import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Goods.Trunk;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.SecondaryProducer.SecondaryProducer;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Visitors.ProducerVisitor;

/**
 * Created by Willie on 4/15/2017.
 */
public class Sawmill extends SecondaryProducer {

    private ProducerRequest input;

    public Sawmill() {
        generateInput();
    }

    private void generateInput() {
        GoodsBag goods = new GoodsBag();
        goods.addTrunk(new Trunk());
        input = new ProducerRequest(goods, null);
    }

    private ProducerRequest generateOutputs() {
        GoodsBag goods = new GoodsBag();
        goods.addBoard(new Board());
        goods.addBoard(new Board());
        return new ProducerRequest(goods, null);
    }

    @Override
    public void accept(ProducerVisitor pv) {
        pv.visitSawmill(this);
    }

    @Override
    public ProducerRequest produce(UserRequest ur) {
        if (!ur.contains(input))
            return null;
        else {
            ur.removeUsed(input);
            ur.reset();
            return generateOutputs();
        }
    }
}
