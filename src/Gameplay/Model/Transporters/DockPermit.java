package Gameplay.Model.Transporters;

import Gameplay.Model.Region.RegionSet;

public class DockPermit implements Permit {

    @Override
    public void getRegions(RegionSet regionSet, Transporter transporter) {
        regionSet.getDockRegions().forEach(
                transporter::addRegion
        );
    }
}
