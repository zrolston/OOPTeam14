package Gameplay.Model.Goods;

import Gameplay.Model.Visitors.CarriableVisitor;
import Gameplay.Model.Visitors.GoodsVisitor;

public class Fuel extends Good{

    @Override
    public void accept(GoodsVisitor goodsVisitor) {
        goodsVisitor.visitFuel(this);
    }

    @Override
    public void accept(CarriableVisitor cv) {
        cv.visitFuel(this);
    }
}
