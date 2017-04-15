package Gameplay.Model.Transporters;

import Gameplay.Model.Visitors.CarriableVisitor;
import Gameplay.Model.Visitors.TransporterVisitor;

/**
 * Created by Willie on 4/14/2017.
 */
public class Wagon extends LandTransporter {
    @Override
    public void accept(CarriableVisitor cv) {
        cv.visitWagon(this);
    }

    @Override
    public void accept(TransporterVisitor tv) {
        tv.visitWagon(this);
    }
}
