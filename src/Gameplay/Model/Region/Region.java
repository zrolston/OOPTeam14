package Gameplay.Model.Region;

import Gameplay.Model.BuildAbilities.BuildAbility;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Utility.Owned;
import Gameplay.Model.Visitors.ConnectionGenerator;
import Gameplay.Model.Visitors.RegionVisitor;

import java.util.Arrays;
import java.util.List;

abstract public class Region {
    private RegionSet regionSet;
    private List<BuildAbility> buildAbilities;

    public Region(BuildAbility...abilities) {
        buildAbilities.addAll(Arrays.asList(abilities));
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

    public List<BuildAbility> getBuildAbilities(Owned owned){
        return buildAbilities;
    }
}
