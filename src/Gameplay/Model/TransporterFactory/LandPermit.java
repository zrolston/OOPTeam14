package Gameplay.Model.TransporterFactory;

import Gameplay.Model.Region.Region;
import Gameplay.Model.Region.RegionSet;
import Gameplay.Model.Transporters.Transporter;

public class LandPermit implements Permit {
    private final Integer LANDMOVEMENTCOST = 2;

    @Override
    public void findRegions(RegionSet regionSet, Transporter transporter) {
        for (Region region : regionSet.getLandRegions()) {
            transporter.addRegion(region, LANDMOVEMENTCOST);
        }
    }
}
