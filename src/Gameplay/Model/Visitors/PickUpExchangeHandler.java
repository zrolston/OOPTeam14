package Gameplay.Model.Visitors;

import Gameplay.Model.Goods.*;

import Gameplay.Model.Transporters.Transporter;

import Gameplay.Model.Utility.TransporterOccupancy;

/**
 * Created by zrgam_000 on 4/16/2017.
 */
public class PickUpExchangeHandler extends ExchangeHandler {

    public PickUpExchangeHandler(TransporterOccupancy occupancy, GoodsBag regionGoodsBag, Transporter target) {
        super(occupancy, regionGoodsBag, target);
    }

    @Override
    public void visitTransporter(Transporter transporter) {
        if(!exchangePossible()){
            return;
        }
        target.pickUpTransporter(transporter);
        occupancy.remove(transporter);
    }

    @Override
    public void visitGood(Good good) {
        if(!exchangePossible()){
            return;
        }
        regionGoodsBag.removeGood(good);
        target.pickUpGood(good);
    }
}
