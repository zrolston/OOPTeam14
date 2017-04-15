package Gameplay.Model.Transporters.WaterTransporter;

import Gameplay.Model.TransporterFactory.Permit;
import Gameplay.Model.Visitors.CarriableVisitor;
import Gameplay.Model.Visitors.TransporterVisitor;

/**
 * Created by Willie on 4/14/2017.
 */
public class Rowboat extends WaterTransporter {

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
