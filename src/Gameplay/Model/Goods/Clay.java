package Gameplay.Model.Goods;

import Gameplay.Model.Visitors.GoodsVisitor;

public class Clay implements Good{

    @Override
    public void accept(GoodsVisitor goodsVisitor) {
        goodsVisitor.visitClay(this);
    }
}
