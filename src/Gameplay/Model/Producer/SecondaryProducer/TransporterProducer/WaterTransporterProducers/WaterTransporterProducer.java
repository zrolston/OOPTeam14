package Gameplay.Model.Producer.SecondaryProducer.TransporterProducer.WaterTransporterProducers;

import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Map.WallHandler;
import Gameplay.Model.Producer.SecondaryProducer.TransporterProducer.SecondaryTransporterProducer;
import Gameplay.Model.Region.Region;
import Gameplay.Model.TransporterFactory.TransporterFactory;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Utility.Owned;

import java.util.List;

/**
 * Created by zrgam_000 on 4/17/2017.
 */
public abstract class WaterTransporterProducer extends SecondaryTransporterProducer {
    List<Region> viableRegions;
    WallHandler wallHandler;

    public WaterTransporterProducer(GoodsBag goodsBag, TransporterFactory tf, Region myRegion, List<Region> regions) {
        super(goodsBag, tf, myRegion);
        viableRegions = regions;
    }

    public boolean addTransporter(Owned owned){
        Transporter transporter = generateOutputs();

        for(Region r : viableRegions){
            if(wallHandler.canPass(r, getRegion(), owned)){
                transporter.setPlayerID(owned.getPlayerID());
                r.enterRegion(transporter);
                getTransporterHandler().place(transporter, r);
                return true;
            }
        }
        return false;
    }
}
