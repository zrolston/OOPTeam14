package Gameplay.Model.Goods;

import Gameplay.Model.Visitors.CarriableVisitor;
import Gameplay.Model.Visitors.GoodsVisitor;

public class Gold extends Good{

    @Override
    public void accept(GoodsVisitor goodsVisitor) {
        goodsVisitor.visitGold(this);
    }

    @Override
    public void accept(CarriableVisitor cv) {
        cv.visitGold(this);
    }
}
