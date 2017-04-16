package Gameplay.Model.Producer.SecondaryProducer.GoodProducer;

import Gameplay.Model.Goods.Coins;
import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Goods.Paper;
import Gameplay.Model.Goods.Stock;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Visitors.ProducerVisitor;

/**
 * Created by Willie on 4/15/2017.
 */
public class StockMarket extends SecondaryGoodProducer {

    private ProducerRequest input;

    public StockMarket() {
        generateInput();
    }

    private void generateInput() {
        GoodsBag goods = new GoodsBag();
        goods.addPaper(new Paper());
        goods.addCoins(new Coins());
        goods.addCoins(new Coins());
        input = new ProducerRequest(goods, null);
    }

    private GoodsBag generateOutputs() {
        GoodsBag goods = new GoodsBag();
        goods.addStock(new Stock());
        return goods;
    }

    @Override
    public void accept(ProducerVisitor pv) {
        pv.visitStockMarket(this);
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
