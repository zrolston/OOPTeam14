package Gameplay.Model.Transporters.WaterTransporter;

import Gameplay.Model.TransporterFactory.Permit;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Visitors.CarriableVisitor;
import Gameplay.Model.Visitors.TransporterVisitor;


public class Rowboat extends Transporter {

    public Rowboat(Permit...permits){
        super(permits);
        setMaxMovement(4);
    }

    @Override
    protected int getMaxCarriables() {
        return 5;
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
