package Gameplay.Model.Visitors;

import Gameplay.Model.Region.LandRegion;
import Gameplay.Model.Region.RiverRegion;
import Gameplay.Model.Region.SeaRegion;

/**
 * Created by Willie on 4/16/2017.
 */
public class RegionPlacableVisitor implements RegionVisitor {

    boolean placable = false;

    @Override
    public void visitLandRegion(LandRegion landRegion) {
        placable = true;
    }

    @Override
    public void visitRiverRegion(RiverRegion riverRegion) {
        placable = false;
    }

    @Override
    public void visitSeaRegion(SeaRegion seaRegion) {
        placable = false;
    }

    public boolean getPlacable() {
        return placable;
    }

}
