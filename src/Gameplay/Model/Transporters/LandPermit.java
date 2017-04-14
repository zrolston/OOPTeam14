package Gameplay.Model.Transporters;

import Gameplay.Model.Tile.RegionSet;

public class LandPermit implements Permit {

    @Override
    public void findRegions(RegionSet regionSet, Transporter transporter) {
        regionSet.getLandRegions().forEach(
                transporter::addRegion
        );
    }
}
