package Gameplay.Model.TransporterFactory;

import Gameplay.Model.Region.Region;
import Gameplay.Model.Region.RegionSet;
import Gameplay.Model.Transporters.Transporter;

public class PortPermit implements Permit {
    private final Integer PORTMOVEMENTCOST = 1;

    @Override
    public void findRegions(RegionSet regionSet, Transporter transporter) {
        for (Region region : regionSet.getPortRegions()) {
            transporter.addRegion(region, PORTMOVEMENTCOST);
        }
    }
}
