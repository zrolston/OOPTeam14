package Gameplay.Model.Producer.SecondaryProducer.TransporterProducer.WaterTransporterProducers;

import Gameplay.Model.Goods.Board;
import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.SecondaryProducer.TransporterProducer.SecondaryTransporterProducer;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Region.Region;
import Gameplay.Model.TransporterFactory.RowboatFactory;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Transporters.WaterTransporter.Rowboat;
import Gameplay.Model.Visitors.ProducerVisitor;

import java.util.List;

/**
 * Created by Willie on 4/15/2017.
 */
public class RowboatProducer extends WaterTransporterProducer {


    public RowboatProducer(Region region, List<Region> connectedRegions) {
        super(new RowboatFactory(), region, connectedRegions);
        setMaxCapacity(1);
        generateInput();
    }

    private void generateInput() {
        GoodsBag goods = new GoodsBag();
        goods.addBoard(new Board());
        goods.addBoard(new Board());
        goods.addBoard(new Board());
        goods.addBoard(new Board());
        goods.addBoard(new Board());
        setInputs(new ProducerRequest(goods, null));
    }

    @Override
    public void accept(ProducerVisitor pv) {
        pv.visitRowboatFactory(this);
    }

}
