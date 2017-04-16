package Gameplay.Model.Region;

import Gameplay.Model.Transporters.LandTransporters.LandTransporter;
import Gameplay.Model.Transporters.WaterTransporter.WaterTransporter;
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

    @Override
    public void doEnterRegion(LandTransporter landTransporter) {
        throw new IllegalStateException("Land transporter can't enter Sea Region!");
    }

    @Override
    public void doEnterRegion(WaterTransporter waterTransporter) {
        waterTransporter.updateMovementSet(getRegionSet());
    }
}
