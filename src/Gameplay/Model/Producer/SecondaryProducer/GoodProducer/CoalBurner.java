package Gameplay.Model.Producer.SecondaryProducer.GoodProducer;

import Gameplay.Model.Goods.Board;
import Gameplay.Model.Goods.Fuel;
import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Goods.Trunk;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Visitors.ProducerVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Willie on 4/15/2017.
 */
public class CoalBurner extends SecondaryGoodProducer {

    private List<ProducerRequest> inputs;

    public CoalBurner(GoodsBag goodsBag) {
        super(goodsBag);
        generateInputs();
    }

    private void generateInputs() {
        inputs = new ArrayList<ProducerRequest>();
        GoodsBag goods1 = new GoodsBag();
        goods1.addBoard(new Board());
        goods1.addBoard(new Board());
        inputs.add(new ProducerRequest(goods1, null));
        GoodsBag goods2 = new GoodsBag();
        goods2.addTrunk(new Trunk());
        goods2.addBoard(new Board());
        inputs.add(new ProducerRequest(goods2, null));
        GoodsBag goods3 = new GoodsBag();
        goods3.addTrunk(new Trunk());
        goods3.addTrunk(new Trunk());
        inputs.add(new ProducerRequest(goods3, null));
    }

    protected GoodsBag generateOutputs() {
        GoodsBag goods = new GoodsBag();
        goods.addFuel(new Fuel());
        return goods;
    }

    @Override
    public void accept(ProducerVisitor pv) {
        pv.visitCoalBurner(this);
    }
}
