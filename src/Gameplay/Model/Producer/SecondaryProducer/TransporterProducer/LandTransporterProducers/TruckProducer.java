package Gameplay.Model.Producer.SecondaryProducer.TransporterProducer.LandTransporterProducers;

import Gameplay.Model.Goods.Fuel;
import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Goods.Iron;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.SecondaryProducer.TransporterProducer.SecondaryTransporterProducer;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Region.Region;
import Gameplay.Model.TransporterFactory.TruckFactory;
import Gameplay.Model.Transporters.LandTransporters.Truck;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Visitors.ProducerVisitor;

/**
 * Created by Willie on 4/15/2017.
 */
public class TruckProducer extends LandTransporterProducer {

    public TruckProducer(Region region) {
        super(new TruckFactory(), region);
        setMaxCapacity(1);
        generateInput();
    }

    private void generateInput() {
        GoodsBag goods = new GoodsBag();
        goods.addFuel(new Fuel());
        goods.addIron(new Iron());
        setInputs(new ProducerRequest(goods, null));
    }

    @Override
    public void accept(ProducerVisitor pv) {
        pv.visitTruckFactory(this);
    }
}
