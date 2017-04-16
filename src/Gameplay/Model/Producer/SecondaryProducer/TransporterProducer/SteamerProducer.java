package Gameplay.Model.Producer.SecondaryProducer.TransporterProducer;

import Gameplay.Model.Goods.Fuel;
import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Goods.Iron;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Transporters.WaterTransporter.Steamer;
import Gameplay.Model.Visitors.ProducerVisitor;

/**
 * Created by Willie on 4/15/2017.
 */
public class SteamerProducer extends SecondaryTransporterProducer {

    private ProducerRequest input;

    public SteamerProducer() {
        generateInput();
    }

    private void generateInput() {
        GoodsBag goods = new GoodsBag();
        goods.addFuel(new Fuel());
        goods.addFuel(new Fuel());
        goods.addIron(new Iron());
        input = new ProducerRequest(goods, null);
    }

    private Transporter generateOutputs() {
        return new Steamer();
    }

    @Override
    public void accept(ProducerVisitor pv) {
        pv.visitSteamerFactory(this);
    }

    @Override
    public Transporter produce(UserRequest ur) {
        if (!ur.contains(input))
            return null;
        else {
            ur.removeUsed(input);
            ur.reset();
            return generateOutputs();
        }
    }
}
