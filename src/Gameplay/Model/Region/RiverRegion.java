package Gameplay.Model.Region;

import Gameplay.Model.BuildAbilities.BuildAbility;
import Gameplay.Model.Visitors.ConnectionGenerator;
import Gameplay.Model.Visitors.RegionVisitor;
import Gameplay.Model.Visitors.RiverConnectionGenerator;

public class RiverRegion extends Region {

    public RiverRegion(BuildAbility...abilities){
        super(abilities);
    }

    @Override
    public void accept(RegionVisitor rv) {
        rv.visitRiverRegion(this);
    }

    @Override
    public ConnectionGenerator getConnectionGenerator() {
        return new RiverConnectionGenerator(getRegionSet());
    }
}
