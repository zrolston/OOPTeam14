package Gameplay.Model.Visitors;

import Gameplay.Model.Region.LandRegion;
import Gameplay.Model.Region.RegionSet;
import Gameplay.Model.Region.RiverRegion;
import Gameplay.Model.Region.SeaRegion;

/**
 * Created by zrgam_000 on 4/14/2017.
 */
public class LandConnectionGenerator extends ConnectionGenerator{

    public LandConnectionGenerator(RegionSet regionSet) {
        super(regionSet);
    }

    @Override
    public void visitLandRegion(LandRegion landRegion) {
        getRegionSet().addLandRegion(landRegion);
    }

    @Override
    public void visitRiverRegion(RiverRegion riverRegion) {
        //NOTHING
    }

    @Override
    public void visitSeaRegion(SeaRegion seaRegion) {
        getRegionSet().addDockRegion(seaRegion);
    }
}
