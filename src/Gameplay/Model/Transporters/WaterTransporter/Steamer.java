package Gameplay.Model.Transporters.WaterTransporter;

import Gameplay.Model.TransporterFactory.Permit;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Visitors.CarriableVisitor;
import Gameplay.Model.Visitors.TransporterVisitor;


public class Steamer extends Transporter {

    public Steamer(Permit...permits){
        super(permits);
        setMaxMovement(6);
    }
    @Override
    public void accept(CarriableVisitor cv) {
        cv.visitSteamer(this);
    }

    @Override
    public void accept(TransporterVisitor tv) {
        tv.visitSteamer(this);
    }
}
