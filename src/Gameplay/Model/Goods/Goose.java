package Gameplay.Model.Goods;

import Gameplay.Model.Utility.Livestock;
import Gameplay.Model.Visitors.GoodsVisitor;

public class Goose implements Good, Livestock{

    @Override
    public void accept(GoodsVisitor goodsVisitor) {
        goodsVisitor.visitGoose(this);
    }
}
