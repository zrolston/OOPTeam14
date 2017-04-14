package Gameplay.Model.Transporters;

import Gameplay.Model.Tile.RegionSet;

public class DockPermit implements Permit {

    @Override
    public void findRegions(RegionSet regionSet, Transporter transporter) {
        regionSet.getDockRegions().forEach(
                transporter::addRegion
        );
    }
}
