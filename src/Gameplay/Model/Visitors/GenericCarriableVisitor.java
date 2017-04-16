package Gameplay.Model.Visitors;

import Gameplay.Model.Goods.Good;
import Gameplay.Model.Transporters.Transporter;

/**
 * Created by zrgam_000 on 4/16/2017.
 */
public interface GenericCarriableVisitor {

    public void visitTransporter(Transporter transporter);
    public void visitGood(Good good);
}
