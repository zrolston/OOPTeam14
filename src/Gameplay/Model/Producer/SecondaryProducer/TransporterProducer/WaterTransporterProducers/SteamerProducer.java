package Gameplay.Model.Producer.SecondaryProducer.TransporterProducer.WaterTransporterProducers;

import Gameplay.Model.Goods.Fuel;
import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Goods.Iron;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.SecondaryProducer.TransporterProducer.SecondaryTransporterProducer;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Region.Region;
import Gameplay.Model.TransporterFactory.SteamerFactory;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Transporters.WaterTransporter.Steamer;
import Gameplay.Model.Visitors.ProducerVisitor;

import java.util.List;

/**
 * Created by Willie on 4/15/2017.
 */
public class SteamerProducer extends WaterTransporterProducer {

    public SteamerProducer(Region region, List<Region> connectedRegions) {
        super(new SteamerFactory(), region, connectedRegions);
        setMaxCapacity(1);
        generateInput();
    }

    private void generateInput() {
        GoodsBag goods = new GoodsBag();
        goods.addFuel(new Fuel());
        goods.addFuel(new Fuel());
        goods.addIron(new Iron());
        setInputs(new ProducerRequest(goods, null));
    }

    @Override
    public void accept(ProducerVisitor pv) {
        pv.visitSteamerFactory(this);
    }
}
