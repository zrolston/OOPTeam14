package Gameplay.Model.TransporterFactory;

import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Transporters.WaterTransporter.Rowboat;

public class RowboatFactory extends TransporterFactory {
    @Override
    public Transporter create() {
        return new Rowboat(new WaterPermit(), new DockPermit());
    }
}
