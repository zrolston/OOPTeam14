package Gameplay.Model.Region;

import Gameplay.Model.Transporters.LandTransporters.LandTransporter;
import Gameplay.Model.Transporters.WaterTransporter.WaterTransporter;
import Gameplay.Model.Visitors.ConnectionGenerator;
import Gameplay.Model.Visitors.RegionVisitor;
import Gameplay.Model.Visitors.RiverConnectionGenerator;

public class RiverRegion extends Region {
    @Override
    public void accept(RegionVisitor rv) {
        rv.visitRiverRegion(this);
    }

    @Override
    public ConnectionGenerator getConnectionGenerator() {
        return new RiverConnectionGenerator(getRegionSet());
    }

    @Override
    public void doEnterRegion(LandTransporter landTransporter) {
        throw new IllegalStateException("Land transporter can't enter River Region!");
    }

    @Override
    public void doEnterRegion(WaterTransporter waterTransporter) {
        waterTransporter.updateMovementSet(getRegionSet());
    }
}
