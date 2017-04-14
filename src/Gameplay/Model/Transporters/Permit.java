package Gameplay.Model.Transporters;

import Gameplay.Model.Tile.RegionSet;

public interface Permit {
    void getRegions(RegionSet regionSet, Transporter transporter);
}
