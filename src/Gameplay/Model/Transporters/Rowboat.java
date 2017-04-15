package Gameplay.Model.Transporters;

import Gameplay.Model.Visitors.CarriableVisitor;
import Gameplay.Model.Visitors.TransporterVisitor;

/**
 * Created by Willie on 4/14/2017.
 */
public class Rowboat extends WaterTransporter {
    @Override
    public void accept(CarriableVisitor cv) {
        cv.visitRowboat(this);
    }

    @Override
    public void accept(TransporterVisitor tv) {
        tv.visitRowboat(this);
    }
}
