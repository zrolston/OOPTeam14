package Gameplay.Model.TransporterFactory;

import Gameplay.Model.Region.Region;
import Gameplay.Model.Region.RegionSet;
import Gameplay.Model.Transporters.Transporter;

public class BridgePermit implements Permit{
    private final Integer BRIDGEMOVEMENTCOST = 0;

    @Override
    public void findRegions(RegionSet regionSet, Transporter transporter) {
        for (Region region : regionSet.getBridgeRegions()) {
            transporter.addRegion(region, BRIDGEMOVEMENTCOST);
        }
    }
}
