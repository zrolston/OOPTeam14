package Gameplay.Model.Transporters.WaterTransporter;

import Gameplay.Model.Region.Region;
import Gameplay.Model.TransporterFactory.Permit;
import Gameplay.Model.Transporters.Transporter;


public abstract class WaterTransporter extends Transporter {
    private boolean isDocked = false;
    private Region port = null;

    public WaterTransporter(Permit... permits){
        super(permits);
    }

    public void setDocked(){
        this.isDocked = true;
        this.port = getCurrentRegion();
        getMovementList().clear();
        addRegion(port);
    }

    public void unDock(){
        isDocked = false;
        port = null;
    }

    public boolean isDocked(){
        return isDocked;
    }
}
