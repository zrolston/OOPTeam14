package Gameplay.Model.Goods;

import Gameplay.Model.Visitors.CarriableVisitor;
import Gameplay.Model.Visitors.GoodsVisitor;

public class Stock extends Good{

    @Override
    public void accept(GoodsVisitor goodsVisitor) {
        goodsVisitor.visitStock(this);
    }

    @Override
    public void accept(CarriableVisitor cv) {
        cv.visitStock(this);
    }
}
