package Gameplay.Model.Transporters;

import Gameplay.Model.Region.RegionSet;

public class WaterPermit implements Permit {

    @Override
    public void findRegions(RegionSet regionSet, Transporter transporter) {
        regionSet.getWaterRegions().forEach(
                transporter::addRegion
        );
    }
}
