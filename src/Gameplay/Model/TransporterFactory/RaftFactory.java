package Gameplay.Model.TransporterFactory;

import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Transporters.WaterTransporter.Raft;

public class RaftFactory extends TransporterFactory {
    @Override
    public Transporter create() {
        return new Raft(new WaterPermit(), new DockPermit(), new PortPermit());
    }
}
