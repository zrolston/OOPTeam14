package Gameplay.Model.Utility;

import java.util.Objects;

/**
 * Created by jordi on 3/26/2017.
 */
public class HexaVertex {
    private static int upperboundary = 6;
    private static int lowerboundary = 0;

    private int value;

    private HexaVertex(int value) {
        this.value = value;
    }

    public static HexaVertex createVertex(int value) throws Exception {
        if (value >= lowerboundary && value <= upperboundary) {
            return new HexaVertex(value);
        }
        throw (new RuntimeException("wrong tile boundary"));
    }

    public HexaVertex getOppositeVertex(){
        int futureValue = (value + 2) % (upperboundary) + 1;
        return new HexaVertex(futureValue);
    }

    public HexaVertex nextVertex(){
        int nextValue = (value % upperboundary) + 1;
        return new HexaVertex(nextValue);
    }

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
