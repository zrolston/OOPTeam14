package Gameplay.Model.TransporterFactory;

import Gameplay.Model.Transporters.LandTransporters.Donkey;
import Gameplay.Model.Transporters.Transporter;

public class DonkeyFactory extends TransporterFactory{
    @Override
    public Transporter create() {
        return new Donkey(new LandPermit(), new RoadPermit());
    }
}
