package Gameplay.Model.Goods;

import Gameplay.Model.Visitors.GoodsVisitor;

public class Iron implements Good{

    @Override
    public void accept(GoodsVisitor goodsVisitor) {
        goodsVisitor.visitIron(this);
    }
}
