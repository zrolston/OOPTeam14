package Gameplay.Model.Transporters.WaterTransporter;

import Gameplay.Model.TransporterFactory.Permit;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Visitors.CarriableVisitor;
import Gameplay.Model.Visitors.TransporterVisitor;


public class Raft extends Transporter {

    public Raft(Permit...permits){
        super(permits);
        setMaxMovement(3);
    }

    @Override
    protected int getMaxCarriables() {
        return 3;
    }

    @Override
    public void accept(CarriableVisitor cv) {
        cv.visitRaft(this);
    }

    @Override
    public void accept(TransporterVisitor tv) {
        tv.visitRaft(this);
    }
}
