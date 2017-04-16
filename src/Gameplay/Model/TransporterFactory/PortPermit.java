package Gameplay.Model.TransporterFactory;

import Gameplay.Model.Region.RegionSet;
import Gameplay.Model.Transporters.Transporter;

public class PortPermit implements Permit {
    @Override
    public void findRegions(RegionSet regionSet, Transporter transporter) {
        if(regionSet.getPortRegions().size() > 0) {
            transporter.addRegion(transporter.getCachedRegion());
        }
    }
}
