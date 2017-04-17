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

    public RaftProducer(GoodsBag goodsBag, Region region, List<Region> connectedRegions) {
        super(goodsBag, new RaftFactory(), region, connectedRegions);
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
