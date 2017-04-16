package Gameplay.Model.TransporterFactory;

import Gameplay.Model.Region.RegionSet;
import Gameplay.Model.Transporters.Transporter;

public interface Permit {
    void findRegions(RegionSet regionSet, Transporter transporter); //TODO make abstract
}
