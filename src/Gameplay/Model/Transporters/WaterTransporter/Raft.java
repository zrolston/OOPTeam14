package Gameplay.Model.Transporters.WaterTransporter;

import Gameplay.Model.TransporterFactory.Permit;
import Gameplay.Model.Visitors.CarriableVisitor;
import Gameplay.Model.Visitors.TransporterVisitor;

/**
 * Created by Willie on 4/14/2017.
 */
public class Raft extends WaterTransporter {

    public Raft(Permit...permits){
        super(permits);
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
