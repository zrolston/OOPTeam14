package Gameplay.Model.TransporterFactory;

import Gameplay.Model.Region.RegionSet;
import Gameplay.Model.Transporters.Transporter;

public class PortPermit implements Permit {
    private final Integer PORTMOVEMENTCOST = 1;

    @Override
    public void findRegions(RegionSet regionSet, Transporter transporter) {
        transporter.addRegion(transporter.getCachedRegion(), 1);
    }
}
