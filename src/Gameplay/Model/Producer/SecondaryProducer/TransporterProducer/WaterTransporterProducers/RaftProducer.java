package Gameplay.Model.Producer.SecondaryProducer.TransporterProducer.WaterTransporterProducers;

import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Goods.Trunk;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.SecondaryProducer.TransporterProducer.SecondaryTransporterProducer;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Region.Region;
import Gameplay.Model.TransporterFactory.RaftFactory;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Transporters.WaterTransporter.Raft;
import Gameplay.Model.Visitors.ProducerVisitor;

import java.util.List;

/**
 * Created by Willie on 4/15/2017.
 */
public class RaftProducer extends WaterTransporterProducer {

    private ProducerRequest input;

    public RaftProducer(Region region, List<Region> connectedRegions) {
        super(new RaftFactory(), region, connectedRegions);
        setMaxCapacity(1);
        generateInput();
    }

    private void generateInput() {
        GoodsBag goods = new GoodsBag();
        goods.addTrunk(new Trunk());
        goods.addTrunk(new Trunk());
        input = new ProducerRequest(goods, null);
    }

    @Override
    public void accept(ProducerVisitor pv) {
        pv.visitRaftFactory(this);
    }
}
