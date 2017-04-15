package Gameplay.Model.Transporters.WaterTransporter;

import Gameplay.Model.Visitors.CarriableVisitor;
import Gameplay.Model.Visitors.TransporterVisitor;

/**
 * Created by Willie on 4/14/2017.
 */
public class Steamer extends WaterTransporter {
    @Override
    public void accept(CarriableVisitor cv) {
        cv.visitSteamer(this);
    }

    @Override
    public void accept(TransporterVisitor tv) {
        tv.visitSteamer(this);
    }
}
