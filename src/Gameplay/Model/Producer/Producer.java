package Gameplay.Model.Producer;

import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Visitors.ProducerVisitor;

public abstract class Producer {
    private GoodsBag goodsBag;

    public Producer(){}

    public abstract void accept(ProducerVisitor pv);

    public GoodsBag getGoodsBag(){
        return goodsBag;
    }

    public void setGoodsBag(GoodsBag goodsBag){
        this.goodsBag = goodsBag;
    }
}
