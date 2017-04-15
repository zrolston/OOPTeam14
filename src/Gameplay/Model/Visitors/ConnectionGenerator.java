package Gameplay.Model.Visitors;

import Gameplay.Model.Region.RegionSet;

/**
 * Created by zrgam_000 on 4/14/2017.
 */
public abstract class ConnectionGenerator implements RegionVisitor{
    private RegionSet regionSet;

    public ConnectionGenerator(RegionSet regionSet){
        this.regionSet = regionSet;
    }

    public RegionSet getRegionSet() {
        return regionSet;
    }
}
