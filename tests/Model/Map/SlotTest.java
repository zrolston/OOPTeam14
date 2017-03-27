package Model.Map;

import Model.Edge.Edge;
import Model.Edge.LandEdge;
import Model.Edge.RiverEdge;
import Model.Edge.SeaEdge;
import Model.Utility.HexaIndex;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by zrgam_000 on 3/26/2017.
 */
public class SlotTest {

    Slot slot1;
    Slot slot2;

    HexaIndex index1;
    HexaIndex index2;
    HexaIndex index3;
    HexaIndex index4;

    HexaIndex index12;
    HexaIndex index22;
    HexaIndex index32;
    HexaIndex index42;

    @Before
    public void TestSetup(){
        slot1 = new Slot();
        slot2 = new Slot();

        try {
            index1 = HexaIndex.createIndex(1);
            index2 = HexaIndex.createIndex(2);
            index3 = HexaIndex.createIndex(3);
            index4 = HexaIndex.createIndex(4);

            index12 = HexaIndex.createIndex(1);
            index22 = HexaIndex.createIndex(2);
            index32 = HexaIndex.createIndex(3);
            index42 = HexaIndex.createIndex(4);
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }

    @Test
    public void addEdge() throws Exception {
        assertEquals(0, slot1.getEdges().size());
        assertEquals(0, slot2.getEdges().size());

        slot1.addEdge(index1, new RiverEdge());

        assertEquals(1, slot1.getEdges().size());
        assertEquals(0, slot2.getEdges().size());

        assertNull(slot1.getEdges().get(index2));

        Edge e = slot1.getEdges().get(index12);
        assertNotNull(e);
    }

    @Test
    public void removeEdge() throws Exception {
        assertEquals(0, slot1.getEdges().size());
        assertEquals(0, slot2.getEdges().size());

        slot1.addEdge(index1, new RiverEdge());

        assertEquals(1, slot1.getEdges().size());
        assertEquals(0, slot2.getEdges().size());

        assertNull(slot1.getEdges().get(index2));

        Edge e = slot1.getEdges().get(index12);
        assertNotNull(e);

        slot1.removeEdge(index12);

        assertNull(slot1.getEdges().get(index2));
        assertNull(slot1.getEdges().get(index12));

        assertEquals(0, slot1.getEdges().size());
        assertEquals(0, slot2.getEdges().size());
    }

    @Test
    public void checkMatch() throws Exception {

        slot1.addEdge(HexaIndex.createIndex(3), new LandEdge());
        slot1.addEdge(HexaIndex.createIndex(4), new LandEdge());

        slot2.addEdge(HexaIndex.createIndex(1), new RiverEdge());
        slot2.addEdge(HexaIndex.createIndex(4), new LandEdge());
        slot2.addEdge(HexaIndex.createIndex(6), new SeaEdge());

        //Fits slot 2
        HashMap<HexaIndex, Edge> RiverMap = new HashMap<HexaIndex, Edge>();
        RiverMap.put(HexaIndex.createIndex(1), new RiverEdge());
        RiverMap.put(HexaIndex.createIndex(2), new LandEdge());
        RiverMap.put(HexaIndex.createIndex(3), new RiverEdge());
        RiverMap.put(HexaIndex.createIndex(4), new LandEdge());
        RiverMap.put(HexaIndex.createIndex(5), new RiverEdge());
        RiverMap.put(HexaIndex.createIndex(6), new LandEdge());

        //Fits slot 1
        HashMap<HexaIndex, Edge> LandMap = new HashMap<HexaIndex, Edge>();
        LandMap.put(HexaIndex.createIndex(1), new LandEdge());
        LandMap.put(HexaIndex.createIndex(2), new LandEdge());
        LandMap.put(HexaIndex.createIndex(3), new LandEdge());
        LandMap.put(HexaIndex.createIndex(4), new LandEdge());
        LandMap.put(HexaIndex.createIndex(5), new LandEdge());
        LandMap.put(HexaIndex.createIndex(6), new LandEdge());

        //Fits slots 1 and 2
        HashMap<HexaIndex, Edge> SeaMap = new HashMap<HexaIndex, Edge>();
        SeaMap.put(HexaIndex.createIndex(1), new SeaEdge());
        SeaMap.put(HexaIndex.createIndex(2), new SeaEdge());
        SeaMap.put(HexaIndex.createIndex(3), new SeaEdge());
        SeaMap.put(HexaIndex.createIndex(4), new SeaEdge());
        SeaMap.put(HexaIndex.createIndex(5), new SeaEdge());
        SeaMap.put(HexaIndex.createIndex(6), new SeaEdge());


        assertTrue(slot1.checkMatch(LandMap));
        assertFalse(slot1.checkMatch(RiverMap));
        assertTrue(slot1.checkMatch(SeaMap));

        assertFalse(slot2.checkMatch(LandMap));
        assertTrue(slot2.checkMatch(RiverMap));
        assertTrue(slot2.checkMatch(SeaMap));


    }

}