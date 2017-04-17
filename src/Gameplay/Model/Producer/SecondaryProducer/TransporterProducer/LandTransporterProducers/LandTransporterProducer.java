package Gameplay.Model.Producer.SecondaryProducer.TransporterProducer.LandTransporterProducers;

import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Map.TransporterHandler;
import Gameplay.Model.Producer.SecondaryProducer.TransporterProducer.SecondaryTransporterProducer;
import Gameplay.Model.Region.Region;
import Gameplay.Model.TransporterFactory.TransporterFactory;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Utility.Owned;

/**
 * Created by zrgam_000 on 4/17/2017.
 */
public abstract class LandTransporterProducer extends SecondaryTransporterProducer {
    public LandTransporterProducer(TransporterFactory tf, Region myRegion) {
        super(tf, myRegion);
    }

    public boolean addTransporter(Owned owned){
        Transporter transporter = generateOutputs();
        transporter.setPlayerID(owned.getPlayerID());
        getRegion().enterRegion(transporter);
        getTransporterHandler().place(transporter, getRegion());
        return true;
    }
}
