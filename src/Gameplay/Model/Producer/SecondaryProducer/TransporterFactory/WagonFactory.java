package Gameplay.Model.Producer.SecondaryProducer.TransporterFactory;

import Gameplay.Model.Goods.Board;
import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.SecondaryProducer.SecondaryProducer;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Transporters.LandTransporters.Donkey;
import Gameplay.Model.Transporters.LandTransporters.Wagon;
import Gameplay.Model.Visitors.ProducerVisitor;

/**
 * Created by Willie on 4/15/2017.
 */
public class WagonFactory extends SecondaryProducer {

    private ProducerRequest input;

    public WagonFactory() {
        generateInput();
    }

    private void generateInput() {
        GoodsBag goods = new GoodsBag();
        goods.addBoard(new Board());
        goods.addBoard(new Board());
        input = new ProducerRequest(goods, new Donkey());
    }

    private ProducerRequest generateOutputs() {
        GoodsBag goods = new GoodsBag();
        return new ProducerRequest(goods, new Wagon());
    }

    @Override
    public void accept(ProducerVisitor pv) {
        pv.visitWagonFactory(this);
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
