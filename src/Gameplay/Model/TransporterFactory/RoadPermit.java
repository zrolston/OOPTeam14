package Gameplay.Model.TransporterFactory;

import Gameplay.Model.Region.Region;
import Gameplay.Model.Region.RegionSet;
import Gameplay.Model.Transporters.Transporter;

public class RoadPermit implements Permit {
    private final Integer ROADMOVEMENTCOST = 1;

    @Override
    public void findRegions(RegionSet regionSet, Transporter transporter) {
        for (Region region : regionSet.getRoadRegions()) {
            transporter.addRegion(region, ROADMOVEMENTCOST);
        }
    }
}
