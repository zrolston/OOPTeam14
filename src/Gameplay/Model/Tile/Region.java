package Gameplay.Model.Tile;

import Gameplay.Model.Transporters.Transporter;

public class Region {
    private RegionSet regionSet;

    public void enterRegion(Transporter transporter){
        transporter.updateMovementSet(regionSet);
    }
}
