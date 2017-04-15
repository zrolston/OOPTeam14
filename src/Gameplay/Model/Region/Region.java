package Gameplay.Model.Region;

import Gameplay.Model.Tile.RegionSet;
import Gameplay.Model.Transporters.Transporter;

abstract public class Region {
    private RegionSet regionSet;

    public void enterRegion(Transporter transporter){
        transporter.updateMovementSet(regionSet);
    }
}
