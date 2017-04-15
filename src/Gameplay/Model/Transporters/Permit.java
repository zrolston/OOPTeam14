package Gameplay.Model.Transporters;

import Gameplay.Model.Tile.RegionSet;

public interface Permit {
    void findRegions(RegionSet regionSet, Transporter transporter);
}
