package Gameplay.Model.Visitors;

import Gameplay.Model.Transporters.*;

/**
 * Created by Willie on 4/14/2017.
 */
public interface TransporterVisitor {
    void visitDonkey(Donkey d);
    void visitWagon(Wagon w);
    void visitTruck(Truck t);
    void visitRaft(Raft r);
    void visitRowboat(Rowboat r);
    void visitSteamer(Steamer s);
}
