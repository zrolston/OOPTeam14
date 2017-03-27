package Model.Map;

import Model.Edge.LandEdge;
import Model.Edge.RiverEdge;
import Model.Edge.SeaEdge;
import Model.Visitor.EdgeVisitor;

/**
 * Created by zrgam_000 on 3/27/2017.
 */
public class RiverCountVisitor implements EdgeVisitor{

    private int riverCount;

    public RiverCountVisitor(){
        riverCount = 0;
    }

    public int getRiverCount(){
        return riverCount;
    }

    public void clearRiverCount(){
        riverCount = 0;
    }

    @Override
    public void visitSeaEdge(SeaEdge seaEdge) {

    }

    @Override
    public void visitLandEdge(LandEdge landEdge) {

    }

    @Override
    public void visitRiverEdge(RiverEdge riverEdge) {

    }
}
