package Model.Utility;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by zrgam_000 on 3/26/2017.
 */
public class LocationTest {

    HexLocation oddCol;
    HexLocation evenCol;

    HexLocation oddSameLoc;
    HexLocation evenSameLoc;

    HexLocation oddNorth;
    HexLocation oddNorthEast;
    HexLocation oddNorthWest;
    HexLocation oddSouth;
    HexLocation oddSouthEast;
    HexLocation oddSouthWest;

    HexLocation evenNorth;
    HexLocation evenNorthEast;
    HexLocation evenNorthWest;
    HexLocation evenSouth;
    HexLocation evenSouthEast;
    HexLocation evenSouthWest;

    @Before
    public void TestSetup(){
        oddCol = new HexLocation(2, 3);
        evenCol = new HexLocation(3, 4);

        oddSameLoc = new HexLocation(2, 3);
        evenSameLoc = new HexLocation(3, 4);

        oddNorth = new HexLocation(1, 3);
        oddNorthEast = new HexLocation(2, 4);
        oddNorthWest = new HexLocation(2, 2);
        oddSouth = new HexLocation(3, 3);
        oddSouthEast = new HexLocation(3, 4);
        oddSouthWest = new HexLocation(3, 2);

        evenNorth = new HexLocation(2, 4);
        evenNorthEast = new HexLocation(2, 5);
        evenNorthWest = new HexLocation(2, 3);
        evenSouth = new HexLocation(4, 4);
        evenSouthEast = new HexLocation(3, 5);
        evenSouthWest = new HexLocation(3, 3);
    }

    @Test
    public void equalsTest(){
        assertTrue(oddCol.equals(oddSameLoc));
        assertTrue(evenCol.equals(evenSameLoc));

        assertFalse(oddCol.equals(evenSameLoc));
    }

    @Test
    public void getRowColTest() {
        assertEquals(3, oddCol.getCol());
        assertEquals(2, oddCol.getRow());
    }

    @Test
    public void getDirectionAtTest() {

        HexaIndex index1 = null;
        HexaIndex index2 = null;
        HexaIndex index3 = null;
        HexaIndex index4 = null;
        HexaIndex index5 = null;
        HexaIndex index6 = null;

        try {
            index1 = HexaIndex.createIndex(1);
            index2 = HexaIndex.createIndex(2);
            index3 = HexaIndex.createIndex(3);
            index4 = HexaIndex.createIndex(4);
            index5 = HexaIndex.createIndex(5);
            index6 = HexaIndex.createIndex(6);
        } catch (Exception e) {
            System.out.print(e.toString());
        }

        assertEquals(oddCol.getLocationAtIndex(index1), (oddNorth));
        assertEquals(oddCol.getLocationAtIndex(index2), (oddNorthEast));
        assertEquals(oddCol.getLocationAtIndex(index6), (oddNorthWest));
        assertEquals(oddCol.getLocationAtIndex(index5), (oddSouthWest));
        assertEquals(oddCol.getLocationAtIndex(index3), (oddSouthEast));
        assertEquals(oddCol.getLocationAtIndex(index4), (oddSouth));

        assertEquals(evenCol.getLocationAtIndex(index1), (evenNorth));
        assertEquals(evenCol.getLocationAtIndex(index2), (evenNorthEast));
        assertEquals(evenCol.getLocationAtIndex(index6), (evenNorthWest));
        assertEquals(evenCol.getLocationAtIndex(index5), (evenSouthWest));
        assertEquals(evenCol.getLocationAtIndex(index3), (evenSouthEast));
        assertEquals(evenCol.getLocationAtIndex(index4), (evenSouth));
    }

    @Test
    public void getAdjacentTest() {
        ArrayList<ILocation> oddTestLocs = oddCol.getAdjacent();
        ArrayList<ILocation> evenTestLocs = evenCol.getAdjacent();

        assertEquals(6, oddTestLocs.size());
        assertEquals(6, evenTestLocs.size());

        assertTrue(oddTestLocs.contains(oddNorth));
        assertTrue(oddTestLocs.contains(oddNorthEast));
        assertTrue(oddTestLocs.contains(oddNorthWest));
        assertTrue(oddTestLocs.contains(oddSouthWest));
        assertTrue(oddTestLocs.contains(oddSouthEast));
        assertTrue(oddTestLocs.contains(oddSouth));

        assertTrue(evenTestLocs.contains(evenNorth));
        assertTrue(evenTestLocs.contains(evenNorthEast));
        assertTrue(evenTestLocs.contains(evenNorthWest));
        assertTrue(evenTestLocs.contains(evenSouthWest));
        assertTrue(evenTestLocs.contains(evenSouthEast));
        assertTrue(evenTestLocs.contains(evenSouth));
    }

}