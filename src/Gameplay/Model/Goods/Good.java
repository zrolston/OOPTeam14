package Gameplay.Model.Goods;

import Gameplay.Model.Visitors.Carriable;
import Gameplay.Model.Visitors.GenericCarriableVisitor;
import Gameplay.Model.Visitors.GoodsVisitor;

public abstract class Good implements Carriable {
    public abstract void accept(GoodsVisitor goodsVisitor);

    public void accept(GenericCarriableVisitor gnv){
        gnv.visitGood(this);
    }
}

