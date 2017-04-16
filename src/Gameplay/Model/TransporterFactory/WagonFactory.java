package Gameplay.Model.TransporterFactory;

import Gameplay.Model.Transporters.LandTransporters.Wagon;
import Gameplay.Model.Transporters.Transporter;

public class WagonFactory extends TransporterFactory {
    @Override
    public Transporter create() {
        return new Wagon(new LandPermit());
    }
}
