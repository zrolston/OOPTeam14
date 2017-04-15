package Gameplay.Model.Goods;

import Gameplay.Model.Visitors.CarriableVisitor;
import Gameplay.Model.Visitors.GoodsVisitor;

public class Paper extends Good{

    @Override
    public void accept(GoodsVisitor goodsVisitor) {
        goodsVisitor.visitPaper(this);
    }

    @Override
    public void accept(CarriableVisitor cv) {
        cv.visitPaper(this);
    }
}
