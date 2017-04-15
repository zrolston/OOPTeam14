package Gameplay.Model.Goods;

import Gameplay.Model.Visitors.GoodsVisitor;

public class Paper implements Good{

    @Override
    public void accept(GoodsVisitor goodsVisitor) {
        goodsVisitor.visitPaper(this);
    }
}
