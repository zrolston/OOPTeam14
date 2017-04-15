package Gameplay.Model.Producer.PrimaryProducer;

import Gameplay.Model.Goods.Gold;
import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Goods.Iron;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Visitors.ProducerVisitor;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Willie on 4/15/2017.
 */
public class Mine extends PrimaryProducer {

    private int numGold;
    private int numIron;

    public Mine() {
        numGold = 3;
        numIron = 3;
    }

    @Override
    public void accept(ProducerVisitor pv) {
        pv.visitMine(this);
    }

    @Override
    public ProducerRequest produce() {
        GoodsBag goods = new GoodsBag();
        if (numGold + numIron == 0)
            return new ProducerRequest(goods, null);
        else {
            int random = ThreadLocalRandom.current().nextInt(0, numGold + numIron);
            if (random < numGold) {
                goods.addGold(new Gold());
                numGold--;
            }
            else {
                goods.addIron(new Iron());
                numIron--;
            }
            return new ProducerRequest(goods, null);
        }
    }
}
