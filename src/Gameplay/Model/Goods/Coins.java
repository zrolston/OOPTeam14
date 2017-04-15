package Gameplay.Model.Goods;

import Gameplay.Model.Visitors.CarriableVisitor;
import Gameplay.Model.Visitors.GoodsVisitor;

public class Coins extends Good{

    @Override
    public void accept(GoodsVisitor goodsVisitor) {
        goodsVisitor.visitCoins(this);
    }

    @Override
    public void accept(CarriableVisitor cv) {
        cv.visitCoins(this);
    }
}
