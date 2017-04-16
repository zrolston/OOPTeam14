package Gameplay.Model.Region;

import Gameplay.Model.Transporters.LandTransporters.LandTransporter;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Transporters.WaterTransporter.WaterTransporter;
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

    public void enterRegion(LandTransporter transporter){
        transporter.setCurrentRegion(this);
        doEnterRegion(transporter);
    }

    public void enterRegion(WaterTransporter transporter){
        transporter.setCurrentRegion(this);
        doEnterRegion(transporter);
    }

    abstract public void doEnterRegion(LandTransporter landTransporter);

    abstract public void doEnterRegion(WaterTransporter waterTransporter);
}
