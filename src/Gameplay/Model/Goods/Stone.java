package Gameplay.Model.Goods;

import Gameplay.Model.Visitors.CarriableVisitor;
import Gameplay.Model.Visitors.GoodsVisitor;

public class Stone extends Good{

    @Override
    public void accept(GoodsVisitor goodsVisitor) {
        goodsVisitor.visitStone(this);
    }

    @Override
    public void accept(CarriableVisitor cv) {
        cv.visitStone(this);
    }
}
