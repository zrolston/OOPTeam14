package Gameplay.Model.Visitors;

import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Utility.TransporterOccupancy;

/**
 * Created by zrgam_000 on 4/16/2017.
 */
public abstract class ExchangeHandler implements GenericCarriableVisitor{
    protected TransporterOccupancy occupancy;
    protected GoodsBag regionGoodsBag;
    protected Transporter target;

    public ExchangeHandler(TransporterOccupancy occupancy, GoodsBag regionGoodsBag, Transporter target){
        this.occupancy = occupancy;
        this.regionGoodsBag = regionGoodsBag;
        this.target = target;
    }

    protected boolean exchangePossible() {
        return target.getCurrentRegion().connectsByBridge(occupancy.getRegion());
    }
}
