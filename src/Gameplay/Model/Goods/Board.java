package Gameplay.Model.Goods;

import Gameplay.Model.Visitors.GoodsVisitor;

public class Board implements Good{

    @Override
    public void accept(GoodsVisitor goodsVisitor) {
        goodsVisitor.visitBoard(this);
    }
}
