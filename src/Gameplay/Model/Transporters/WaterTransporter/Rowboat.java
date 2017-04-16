package Gameplay.Model.Transporters.WaterTransporter;

import Gameplay.Model.TransporterFactory.Permit;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Visitors.CarriableVisitor;
import Gameplay.Model.Visitors.TransporterVisitor;


public class Rowboat extends Transporter {

    public Rowboat(Permit...permits){
        super(permits);
    }
    @Override
    public void accept(CarriableVisitor cv) {
        cv.visitRowboat(this);
    }

    @Override
    public void accept(TransporterVisitor tv) {
        tv.visitRowboat(this);
    }
}
