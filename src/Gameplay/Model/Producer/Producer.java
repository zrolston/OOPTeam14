package Gameplay.Model.Producer;

import Gameplay.Model.Visitors.ProducerVisitor;

/**
 * Created by Willie on 4/15/2017.
 */
public abstract class Producer {
    public abstract void accept(ProducerVisitor pv);
}
