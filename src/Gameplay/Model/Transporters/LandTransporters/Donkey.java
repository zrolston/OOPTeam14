package Gameplay.Model.Transporters.LandTransporters;

import Gameplay.Model.TransporterFactory.Permit;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Visitors.CarriableVisitor;
import Gameplay.Model.Visitors.TransporterVisitor;

public class Donkey extends Transporter {

    public Donkey(Permit...permits){
        super(permits);
        setMaxMovement(2);
    }

    @Override
    public void accept(CarriableVisitor cv) {
        cv.visitDonkey(this);
    }

    @Override
    public void accept(TransporterVisitor tv) {
        tv.visitDonkey(this);
    }
}
