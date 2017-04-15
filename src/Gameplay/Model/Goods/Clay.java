package Gameplay.Model.Goods;

import Gameplay.Model.Visitors.CarriableVisitor;
import Gameplay.Model.Visitors.GoodsVisitor;

public class Clay extends Good{

    @Override
    public void accept(GoodsVisitor goodsVisitor) {
        goodsVisitor.visitClay(this);
    }

    @Override
    public void accept(CarriableVisitor cv) {
        cv.visitClay(this);
    }
}
