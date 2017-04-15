package Gameplay.Model.Goods;

import Gameplay.Model.Visitors.CarriableVisitor;
import Gameplay.Model.Visitors.GoodsVisitor;

public class Trunk extends Good{

    @Override
    public void accept(GoodsVisitor goodsVisitor) {
        goodsVisitor.visitTrunk(this);
    }

    @Override
    public void accept(CarriableVisitor cv) {
        cv.visitTrunk(this);
    }
}
