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
public class Mint extends SecondaryGoodFactory {

    private ProducerRequest input;

    public Mint() {
        generateInput();
    }

    private void generateInput() {
        GoodsBag goods = new GoodsBag();
        goods.addFuel(new Fuel());
        goods.addGold(new Gold());
        goods.addGold(new Gold());
        input = new ProducerRequest(goods, null);
    }

    private GoodsBag generateOutputs() {
        GoodsBag goods = new GoodsBag();
        goods.addCoins(new Coins());
        return goods;
    }

    @Override
    public void accept(ProducerVisitor pv) {
        pv.visitMint(this);
    }

    @Override
    public GoodsBag produce(UserRequest ur) {
        if (!ur.contains(input))
            return new GoodsBag();
        else {
            ur.removeUsed(input);
            ur.reset();
            return generateOutputs();
        }
    }
}
