package Gameplay.Model.Producer.SecondaryProducer.TransporterFactory;

import Gameplay.Model.Goods.Fuel;
import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Goods.Iron;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.SecondaryProducer.SecondaryProducer;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Transporters.WaterTransporter.Steamer;
import Gameplay.Model.Visitors.ProducerVisitor;

/**
 * Created by Willie on 4/15/2017.
 */
public class SteamerFactory extends SecondaryProducer {

    private ProducerRequest input;

    public SteamerFactory() {
        generateInput();
    }

    private void generateInput() {
        GoodsBag goods = new GoodsBag();
        goods.addFuel(new Fuel());
        goods.addFuel(new Fuel());
        goods.addIron(new Iron());
        input = new ProducerRequest(goods, null);
    }

    private ProducerRequest generateOutputs() {
        GoodsBag goods = new GoodsBag();
        return new ProducerRequest(goods, new Steamer());
    }

    @Override
    public void accept(ProducerVisitor pv) {
        pv.visitSteamerFactory(this);
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
