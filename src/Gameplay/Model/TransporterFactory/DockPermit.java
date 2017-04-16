package Gameplay.Model.TransporterFactory;

import Gameplay.Model.Region.Region;
import Gameplay.Model.Region.RegionSet;
import Gameplay.Model.Transporters.Transporter;

public class DockPermit implements Permit {
    private final Integer DOCKMOVEMENTCOST = 1;

    @Override
    public void findRegions(RegionSet regionSet, Transporter transporter) {
        for (Region region : regionSet.getDockRegions()) {
            transporter.addRegion(region, DOCKMOVEMENTCOST);
        }
    }
}
