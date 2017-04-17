package Gameplay.Model.Transporters.LandTransporters;

import Gameplay.Model.TransporterFactory.Permit;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Visitors.CarriableVisitor;
import Gameplay.Model.Visitors.TransporterVisitor;

public class Truck extends Transporter {

    public Truck(Permit...permits){
        super(permits);
        setMaxMovement(4);
    }

    @Override
    protected int getMaxCarriables() {
        return 6;
    }

    @Override
    public void accept(CarriableVisitor cv) {
        cv.visitTruck(this);
    }

    @Override
    public void accept(TransporterVisitor tv) {
        tv.visitTruck(this);
    }
}
