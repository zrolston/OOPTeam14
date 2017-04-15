package Gameplay.Model.Visitors;

import Gameplay.Model.Region.LandRegion;
import Gameplay.Model.Region.RiverRegion;
import Gameplay.Model.Region.SeaRegion;

/**
 * Created by zrgam_000 on 4/14/2017.
 */
public interface RegionVisitor {
    public void visitLandRegion(LandRegion landRegion);
    public void visitRiverRegion(RiverRegion riverRegion);
    public void visitSeaRegion(SeaRegion seaRegion);
}
