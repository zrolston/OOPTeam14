package Model.Utility;

/**
 * Created by jordi on 3/26/2017.
 */
public class HexaIndex {
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

    public HexaIndex getOppositeSide() throws Exception {
        int futureValue = (value + 2) % (upperboundary - 1) + 1;
        return HexaIndex.createIndex(futureValue);
    }

    public int getValue() {
        return value;
    }
}
