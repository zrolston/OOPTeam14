package Model.Utility;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jordi on 3/26/2017.
 */
public class HexaIndexTest {
    @Test
    public void createIndex() throws Exception {
        String exceptionMsg="wrong tile boundary";

        HexaIndex hexaIndex = HexaIndex.createIndex(5);
        assertEquals(5, hexaIndex.getValue());

        try {
            hexaIndex= HexaIndex.createIndex(7);
        } catch (Exception e) {
            assertEquals(exceptionMsg,e.getMessage());
        }
    }

    @Test
    public void oppositeSide() throws Exception {
        HexaIndex hexaIndex = HexaIndex.createIndex(4);
        assertEquals(1, hexaIndex.getOppositeSide().getValue());

        hexaIndex = HexaIndex.createIndex(1);
        assertEquals(4, hexaIndex.getOppositeSide().getValue());

        hexaIndex = HexaIndex.createIndex(3);
        assertEquals(6, hexaIndex.getOppositeSide().getValue());

        hexaIndex = HexaIndex.createIndex(6);
        assertEquals(3, hexaIndex.getOppositeSide().getValue());

        hexaIndex = HexaIndex.createIndex(1);
        assertEquals(4, hexaIndex.getOppositeSide().getValue());

    }

}