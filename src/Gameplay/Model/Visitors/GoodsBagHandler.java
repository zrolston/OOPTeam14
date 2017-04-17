package Gameplay.Model.Visitors;

import Gameplay.Model.Goods.GoodsBag;

/**
 * Created by zrgam_000 on 4/16/2017.
 */
public abstract class GoodsBagHandler implements GoodsVisitor{
    protected GoodsBag goodsBag;

    public GoodsBagHandler(GoodsBag goodsBag){
        this.goodsBag = goodsBag;
    }
}
