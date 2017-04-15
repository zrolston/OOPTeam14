package Gameplay.Model.Transporters;

import Gameplay.Model.Region.RegionSet;

public class RoadPermit implements Permit {

    @Override
    public void getRegions(RegionSet regionSet, Transporter transporter) {
        regionSet.getRoadRegions().forEach(
                transporter::addRegion
        );
    }
}