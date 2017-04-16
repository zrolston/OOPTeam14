package Gameplay.Model.Producer.SecondaryProducer.TransporterFactory;

import Gameplay.Model.Goods.Fuel;
import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Goods.Iron;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.SecondaryProducer.GoodProducer.SecondaryGoodFactory;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Transporters.LandTransporters.Truck;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Visitors.ProducerVisitor;

/**
 * Created by Willie on 4/15/2017.
 */
public class TruckFactory extends SecondaryTransporterFactory {

    private ProducerRequest input;

    public TruckFactory() {
        generateInput();
    }

    private void generateInput() {
        GoodsBag goods = new GoodsBag();
        goods.addFuel(new Fuel());
        goods.addIron(new Iron());
        input = new ProducerRequest(goods, null);
    }

    private Transporter generateOutputs() {
        return new Truck();
    }

    @Override
    public void accept(ProducerVisitor pv) {
        pv.visitTruckFactory(this);
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
