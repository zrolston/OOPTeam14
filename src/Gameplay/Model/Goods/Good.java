package Gameplay.Model.Goods;

import Gameplay.Model.Visitors.GoodsVisitor;

public interface Good {
    void accept(GoodsVisitor goodsVisitor);
}

