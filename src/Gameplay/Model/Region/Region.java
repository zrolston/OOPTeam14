package Gameplay.Model.Region;

import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Visitors.ConnectionGenerator;
import Gameplay.Model.Visitors.RegionVisitor;

abstract public class Region {
    private RegionSet regionSet;

    public Region() {
        regionSet = new RegionSet();
    }

    public abstract void accept(RegionVisitor rv);

    public abstract ConnectionGenerator getConnectionGenerator();

    public RegionSet getRegionSet(){
        return regionSet;
    }

    public void enterRegion(Transporter transporter){
        transporter.setCurrentRegion(this);
        transporter.updateMovementSet(getRegionSet());
    }

    public boolean connectsToByLand(Region r2) {
        return regionSet.connectsByLand(r2);
    }
}
