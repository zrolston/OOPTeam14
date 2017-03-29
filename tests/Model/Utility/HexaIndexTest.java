package Model.Utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

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

    @Test
    public void getAllPossibleTest() throws Exception {
        ArrayList<HexaIndex> list = HexaIndex.getAllPossible();

        assertEquals(6, list.size());
        assertTrue(list.contains(HexaIndex.createIndex(1)));
        assertTrue(list.contains(HexaIndex.createIndex(2)));
        assertTrue(list.contains(HexaIndex.createIndex(3)));
        assertTrue(list.contains(HexaIndex.createIndex(4)));
        assertTrue(list.contains(HexaIndex.createIndex(5)));
        assertTrue(list.contains(HexaIndex.createIndex(6)));
    }

}