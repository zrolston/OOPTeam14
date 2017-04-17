package Gameplay.Model.Producer.SecondaryProducer.GoodProducer;

import Gameplay.Model.Goods.Board;
import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Goods.Trunk;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Visitors.ProducerVisitor;

/**
 * Created by Willie on 4/15/2017.
 */
public class Sawmill extends SecondaryGoodProducer {

    private ProducerRequest input;

    public Sawmill(GoodsBag goodsBag) {
        super(goodsBag);
        generateInput();
    }

    private void generateInput() {
        GoodsBag goods = new GoodsBag();
        goods.addTrunk(new Trunk());
        input = new ProducerRequest(goods, null);
    }

    protected GoodsBag generateOutputs() {
        GoodsBag goods = new GoodsBag();
        goods.addBoard(new Board());
        goods.addBoard(new Board());
        return goods;
    }

    @Override
    public void accept(ProducerVisitor pv) {
        pv.visitSawmill(this);
    }

}
