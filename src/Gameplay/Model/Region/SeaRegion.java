package Gameplay.Model.Region;

import Gameplay.Model.Visitors.ConnectionGenerator;
import Gameplay.Model.Visitors.RegionVisitor;
import Gameplay.Model.Visitors.SeaConnectionGenerator;

public class SeaRegion extends Region {

    @Override
    public void accept(RegionVisitor rv) {
        rv.visitSeaRegion(this);
    }

    @Override
    public ConnectionGenerator getConnectionGenerator() {
        return new SeaConnectionGenerator(getRegionSet());
    }
}
