package Gameplay.Model.Transporters.LandTransporters;

import Gameplay.Model.TransporterFactory.Permit;
import Gameplay.Model.Transporters.Transporter;

public abstract class LandTransporter extends Transporter {
    public LandTransporter(Permit...permits){
        super(permits);
    }
}
