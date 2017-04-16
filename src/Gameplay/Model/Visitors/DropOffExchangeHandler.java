package Gameplay.Model.Visitors;

import Gameplay.Model.Goods.*;
import Gameplay.Model.Transporters.LandTransporters.Donkey;
import Gameplay.Model.Transporters.LandTransporters.Truck;
import Gameplay.Model.Transporters.LandTransporters.Wagon;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Transporters.WaterTransporter.Raft;
import Gameplay.Model.Transporters.WaterTransporter.Rowboat;
import Gameplay.Model.Transporters.WaterTransporter.Steamer;
import Gameplay.Model.Utility.TransporterOccupancy;

/**
 * Created by zrgam_000 on 4/16/2017.
 */
public class DropOffExchangeHandler extends ExchangeHandler {

    public DropOffExchangeHandler(TransporterOccupancy occupancy, GoodsBag regionGoodsBag, Transporter target) {
        super(occupancy, regionGoodsBag, target);
    }

    @Override
    public void visitTransporter(Transporter transporter) {
        target.dropTransporter();
        occupancy.add(transporter);
        transporter.moveTo(occupancy.getRegion());
    }

    @Override
    public void visitGood(Good good) {
        target.dropGood(good);
        regionGoodsBag.addGood(good);
    }
}
