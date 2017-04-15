package Gameplay.Model.Goods;

import Gameplay.Model.Visitors.CarriableVisitor;
import Gameplay.Model.Visitors.GoodsVisitor;

public class Board extends Good{

    @Override
    public void accept(GoodsVisitor goodsVisitor) {
        goodsVisitor.visitBoard(this);
    }

    @Override
    public void accept(CarriableVisitor cv) {
        cv.visitBoard(this);
    }
}
