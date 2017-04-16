package Gameplay.Model.Transporters.LandTransporters;

import Gameplay.Model.Region.RegionSet;
import Gameplay.Model.TransporterFactory.Permit;
import Gameplay.Model.Visitors.CarriableVisitor;
import Gameplay.Model.Visitors.TransporterVisitor;

public class Wagon extends LandTransporter {

    public Wagon(Permit...permits){
        super(permits);
    }

    @Override
    public void accept(CarriableVisitor cv) {
        cv.visitWagon(this);
    }

    @Override
    public void accept(TransporterVisitor tv) {
        tv.visitWagon(this);
    }
}
