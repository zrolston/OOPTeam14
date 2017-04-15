package Gameplay.Model.Transporters.WaterTransporter;

import Gameplay.Model.TransporterFactory.Permit;
import Gameplay.Model.Transporters.Transporter;


public abstract class WaterTransporter extends Transporter {
    public WaterTransporter(Permit... permits){
        super(permits);
    }
}
