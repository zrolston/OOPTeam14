package Gameplay.Model.Transporters;

import Gameplay.Model.Region.RegionSet;

public interface Permit {
    void getRegions(RegionSet regionSet, Transporter transporter);
}
