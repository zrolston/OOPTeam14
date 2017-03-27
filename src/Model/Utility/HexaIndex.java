package Model.Utility;

import java.util.Objects;

/**
 * Created by jordi on 3/26/2017.
 */
public class HexaIndex{
    private static int upperboundary = 7;
    private static int lowerboundary = 0;

    private int value;

    private HexaIndex(int value) {
        this.value = value;
    }

    public static HexaIndex createIndex(int value) throws Exception {
        if (value > lowerboundary && value < upperboundary) {
            return new HexaIndex(value);
        }
        throw (new RuntimeException("wrong tile boundary"));
    }

    public HexaIndex getOppositeSide(){
        int futureValue = (value + 2) % (upperboundary - 1) + 1;
        return new HexaIndex(futureValue);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object ind){
        boolean equal = ind instanceof HexaIndex;
        if(!equal)
            return false;

        HexaIndex myOther = (HexaIndex) ind;
        return this.equals(myOther);
    }


    public boolean equals(HexaIndex hexIndex){
        return this.value == hexIndex.getValue() ;
    }

    public int hashCode(){
        return Objects.hash(this.value);
    }
}
