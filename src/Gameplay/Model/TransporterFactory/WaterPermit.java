package Gameplay.Model.TransporterFactory;

import Gameplay.Model.Region.Region;
import Gameplay.Model.Region.RegionSet;
import Gameplay.Model.Transporters.Transporter;

public class WaterPermit implements Permit {
    private final Integer WATERMOVEMENTCOST = 1;

    @Override
    public void findRegions(RegionSet regionSet, Transporter transporter) {
        for (Region region : regionSet.getWaterRegions()) {
            transporter.addRegion(region, WATERMOVEMENTCOST);
        }
    }
}
