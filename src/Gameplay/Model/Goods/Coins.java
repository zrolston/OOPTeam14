package Gameplay.Model.Goods;

import Gameplay.Model.Visitors.GoodsVisitor;

public class Coins implements Good{

    @Override
    public void accept(GoodsVisitor goodsVisitor) {
        goodsVisitor.visitCoins(this);
    }
}
