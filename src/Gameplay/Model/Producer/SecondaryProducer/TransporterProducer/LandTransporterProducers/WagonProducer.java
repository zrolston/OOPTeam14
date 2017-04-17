package Gameplay.Model.Producer.SecondaryProducer.TransporterProducer.LandTransporterProducers;

import Gameplay.Model.Goods.Board;
import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.SecondaryProducer.TransporterProducer.SecondaryTransporterProducer;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Region.Region;
import Gameplay.Model.TransporterFactory.WagonFactory;
import Gameplay.Model.Transporters.LandTransporters.Donkey;
import Gameplay.Model.Transporters.LandTransporters.Wagon;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Visitors.ProducerVisitor;

/**
 * Created by Willie on 4/15/2017.
 */
public class WagonProducer extends LandTransporterProducer {

    private ProducerRequest input;

    public WagonProducer(Region region) {
        super(new WagonFactory(), region);
        setMaxCapacity(1);
        generateInput();
    }

    private void generateInput() {
        GoodsBag goods = new GoodsBag();
        goods.addBoard(new Board());
        goods.addBoard(new Board());
        input = new ProducerRequest(goods, new Donkey());
    }

    @Override
    public void accept(ProducerVisitor pv) {
        pv.visitWagonFactory(this);
    }


}
