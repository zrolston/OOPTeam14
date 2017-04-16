package Gameplay.Model.TransporterFactory;

import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Transporters.WaterTransporter.Steamer;

public class SteamerFactory extends TransporterFactory {
    @Override
    public Transporter create() {
        return new Steamer(new WaterPermit(), new DockPermit());
    }
}
