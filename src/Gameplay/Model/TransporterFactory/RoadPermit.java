package Gameplay.Model.TransporterFactory;

import Gameplay.Model.Region.RegionSet;
import Gameplay.Model.Transporters.Transporter;

public class RoadPermit implements Permit {

    @Override
    public void findRegions(RegionSet regionSet, Transporter transporter) {
        regionSet.getRoadRegions().forEach(
                transporter::addRegion
        );
    }
}
