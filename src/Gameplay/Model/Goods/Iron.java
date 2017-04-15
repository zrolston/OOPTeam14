package Gameplay.Model.Goods;

import Gameplay.Model.Visitors.CarriableVisitor;
import Gameplay.Model.Visitors.GoodsVisitor;

public class Iron extends Good{

    @Override
    public void accept(GoodsVisitor goodsVisitor) {
        goodsVisitor.visitIron(this);
    }

    @Override
    public void accept(CarriableVisitor cv) {
        cv.visitIron(this);
    }
}
