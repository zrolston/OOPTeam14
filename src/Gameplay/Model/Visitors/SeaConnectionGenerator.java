package Gameplay.Model.Visitors;

import Gameplay.Model.Region.LandRegion;
import Gameplay.Model.Region.RegionSet;
import Gameplay.Model.Region.RiverRegion;
import Gameplay.Model.Region.SeaRegion;

/**
 * Created by zrgam_000 on 4/14/2017.
 */
public class SeaConnectionGenerator extends ConnectionGenerator {

    public SeaConnectionGenerator(RegionSet regionSet) {
        super(regionSet);
    }

    @Override
    public void visitLandRegion(LandRegion landRegion) {
        getRegionSet().addDockRegion(landRegion);
    }

    @Override
    public void visitRiverRegion(RiverRegion riverRegion) {
        getRegionSet().addWaterRegion(riverRegion);
    }

    @Override
    public void visitSeaRegion(SeaRegion seaRegion) {
        getRegionSet().addWaterRegion(seaRegion);
    }
}
