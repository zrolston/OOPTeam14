package Gameplay.Model.Goods;

import Gameplay.Model.Utility.Livestock;
import Gameplay.Model.Visitors.CarriableVisitor;
import Gameplay.Model.Visitors.GoodsVisitor;

public class Goose extends Good implements Livestock{

    @Override
    public void accept(GoodsVisitor goodsVisitor) {
        goodsVisitor.visitGoose(this);
    }

    @Override
    public void accept(CarriableVisitor cv) {
        cv.visitGoose(this);
    }
}
