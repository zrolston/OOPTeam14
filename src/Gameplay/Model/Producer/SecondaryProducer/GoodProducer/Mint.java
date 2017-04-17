package Gameplay.Model.Producer.SecondaryProducer.GoodProducer;

import Gameplay.Model.Goods.Coins;
import Gameplay.Model.Goods.Fuel;
import Gameplay.Model.Goods.Gold;
import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Visitors.ProducerVisitor;

/**
 * Created by Willie on 4/15/2017.
 */
public class Mint extends SecondaryGoodProducer {

    private ProducerRequest input;

    public Mint() {
        setMaxCapacity(1);
        generateInput();
    }

    private void generateInput() {
        GoodsBag goods = new GoodsBag();
        goods.addFuel(new Fuel());
        goods.addGold(new Gold());
        goods.addGold(new Gold());
        input = new ProducerRequest(goods, null);
    }

    protected GoodsBag generateOutputs() {
        GoodsBag goods = new GoodsBag();
        goods.addCoins(new Coins());
        return goods;
    }

    @Override
    public void accept(ProducerVisitor pv) {
        pv.visitMint(this);
    }
}
