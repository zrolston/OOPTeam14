package Gameplay.Model.Transporters;

import Gameplay.Model.Region.RegionSet;

public interface Permit {
    void findRegions(RegionSet regionSet, Transporter transporter);
}
