package Gameplay.Model.Transporters.LandTransporters;

import Gameplay.Model.TransporterFactory.Permit;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Visitors.CarriableVisitor;
import Gameplay.Model.Visitors.TransporterVisitor;

public class Wagon extends Transporter {

    public Wagon(Permit...permits){
        super(permits);
        setMaxMovement(3);
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
