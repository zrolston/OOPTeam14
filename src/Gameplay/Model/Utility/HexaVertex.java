package Gameplay.Model.Utility;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by jordi on 3/26/2017.
 */
public class HexaVertex {
    private static int vertexLowerBoundary = 1;
    private static int vertexUpperBoundary = 6;
    private static int edgeLowerBoundary = 7;
    private static int edgeUpperBoundary = 12;

    private int value;

    public static int getVertexUpperBoundary() {
        return vertexUpperBoundary;
    }
    public static int getEdgeUpperBoundary() {
        return edgeUpperBoundary;
    }

    private HexaVertex(int value) {
        this.value = value;
    }

    public HexaVertex(int value, int testing) {
        this.value = value;
    }

    public static HexaVertex createVertex(int value) throws Exception {

        if (value >= vertexLowerBoundary && value <= edgeUpperBoundary) {
            return new HexaVertex(value);
        }
        throw (new RuntimeException("wrong tile boundary"));
    }

    public HexaVertex nextVertex(){
        if (value >= vertexLowerBoundary && value <= vertexUpperBoundary){
            int nextValue = (value % vertexUpperBoundary) + 1;
            return new HexaVertex(nextValue);
        }
        else{
            int nextValue = (value % edgeUpperBoundary) + 1;
            return new HexaVertex(nextValue);
        }
    }
//      NEVER USED
//    public static ArrayList<HexaVertex> getAllPossible(){
//        ArrayList<HexaVertex> hexaIndices = new ArrayList<>();
//
//        for(int i = lowerboundary; i<upperboundary; i++){
//            hexaIndices.add(new HexaVertex(i));
//        }
//
//        return hexaIndices;
//    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object ind){
        boolean equal = ind instanceof HexaVertex;
        if(!equal)
            return false;

        HexaVertex myOther = (HexaVertex) ind;
        return this.equals(myOther);
    }

    public boolean equals(HexaVertex hexVertex){
        return this.value == hexVertex.getValue() ;
    }

    public int hashCode(){
        return Objects.hash(this.value);
    }
}
