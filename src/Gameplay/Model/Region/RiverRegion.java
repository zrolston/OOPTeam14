package Gameplay.Model.Region;

import Gameplay.Model.Visitors.ConnectionGenerator;
import Gameplay.Model.Visitors.RegionVisitor;
import Gameplay.Model.Visitors.RiverConnectionGenerator;

/**
 * Created by zrgam_000 on 4/14/2017.
 */
public class RiverRegion extends Region {
    @Override
    public void accept(RegionVisitor rv) {
        rv.visitRiverRegion(this);
    }

    @Override
    public ConnectionGenerator getConnectionGenerator() {
        return new RiverConnectionGenerator(getRegionSet());
    }
}
