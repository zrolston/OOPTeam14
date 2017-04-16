package Gameplay.Model.TransporterFactory;

import Gameplay.Model.Transporters.LandTransporters.Truck;
import Gameplay.Model.Transporters.Transporter;

public class TruckFactory extends TransporterFactory{
    @Override
    public Transporter create() {
        return new Truck(new RoadPermit(), new BridgePermit());
    }
}
