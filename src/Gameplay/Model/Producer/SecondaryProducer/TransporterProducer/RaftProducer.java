package Gameplay.Model.Producer.SecondaryProducer.TransporterProducer;

import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Goods.Trunk;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Transporters.WaterTransporter.Raft;
import Gameplay.Model.Visitors.ProducerVisitor;

/**
 * Created by Willie on 4/15/2017.
 */
public class RaftProducer extends SecondaryTransporterProducer {

    private ProducerRequest input;

    public RaftProducer() {
        generateInput();
    }

    private void generateInput() {
        GoodsBag goods = new GoodsBag();
        goods.addTrunk(new Trunk());
        goods.addTrunk(new Trunk());
        input = new ProducerRequest(goods, null);
    }

    private Transporter generateOutputs() {
        return new Raft();
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
