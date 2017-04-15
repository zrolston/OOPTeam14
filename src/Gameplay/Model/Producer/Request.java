package Gameplay.Model.Producer;

import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Transporters.Transporter;

abstract public class Request {
    public boolean contains(Request r) {
        if (this.getTransporter() == null)
            return this.getGoodsBag().contains(r.getGoodsBag());
        else if (this.getTransporter().getClass() == r.getTransporter().getClass())
            return this.getGoodsBag().contains(r.getGoodsBag());
        else
            return false;
    }

    public abstract GoodsBag getGoodsBag();
    public abstract Transporter getTransporter();
}
