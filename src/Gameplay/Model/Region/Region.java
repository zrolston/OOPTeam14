package Gameplay.Model.Region;

import Gameplay.Model.Visitors.ConnectionGenerator;
import Gameplay.Model.Visitors.RegionVisitor;

public abstract class Region {
    private RegionSet regionSet;

    public Region(){
        regionSet = new RegionSet();
    }

    public abstract void accept(RegionVisitor rv);
    public abstract ConnectionGenerator getConnectionGenerator();

    public RegionSet getRegionSet() {
        return regionSet;
    }
}
