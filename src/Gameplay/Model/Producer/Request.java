package Gameplay.Model.Producer;

import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Utility.Owned;

abstract public class Request extends Owned {
    public boolean contains(Request r) {
        if (this.getTransporter() == null)
            return this.getGoodsBag().contains(r.getGoodsBag());
        else if (r.getTransporter()!= null && this.getTransporter().getClass().equals(r.getTransporter().getClass()))
            return this.getGoodsBag().contains(r.getGoodsBag());
        else
            return false;
    }

    public abstract GoodsBag getGoodsBag();
    public abstract Transporter getTransporter();
}
