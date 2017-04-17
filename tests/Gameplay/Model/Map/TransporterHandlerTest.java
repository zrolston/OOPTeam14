package Gameplay.Model.Map;

import Gameplay.Model.Region.LandRegion;
import Gameplay.Model.Region.Region;
import Gameplay.Model.TransporterFactory.DonkeyFactory;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Utility.PlayerID;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zrgam_000 on 4/15/2017.
 */
public class TransporterHandlerTest {

    TransporterHandler th;

    Transporter t11;
    Transporter t12;
    Transporter t21;
    Transporter t22;

    Region r1;
    Region r2;
    Region none;

    PlayerID p1;
    PlayerID p2;

    @Before
    public void TestSetup(){

        th = TransporterHandler.getInstance();

        DonkeyFactory df = new DonkeyFactory();

        p1 = PlayerID.getPlayer1ID();
        p2 = PlayerID.getPlayer2ID();

        t11 = df.create();
        t11.setPlayerID(p1);

        t12 = df.create();
        t12.setPlayerID(p1);

        t21 = df.create();
        t21.setPlayerID(p2);

        t22 = df.create();
        t22.setPlayerID(p2);

        r1 = new LandRegion();
        r2 = new LandRegion();
        none = new LandRegion();

        th.place(t11, r1);
        th.place(t12, r2);
        th.place(t21, r1);

    }

    @Test
    public void place() throws Exception {
        assertEquals(0, th.getTransportersAt(none).size());
        assertEquals(2, th.getTransportersAt(r1).size());
        assertEquals(1, th.getTransportersAt(r2).size());

        assertEquals(1, th.getMyTransportersAt(r1, t11).size());
        assertEquals(1, th.getMyTransportersAt(r1, t22).size());

        assertEquals(1, th.getMyTransportersAt(r2, t11).size());
        assertEquals(0, th.getMyTransportersAt(r2, t22).size());

        assertEquals(0, th.getMyTransportersAt(none, t11).size());
        assertEquals(0, th.getMyTransportersAt(none, t22).size());

        th.place(t22, r2);

        assertEquals(0, th.getTransportersAt(none).size());
        assertEquals(2, th.getTransportersAt(r1).size());
        assertEquals(2, th.getTransportersAt(r2).size());

        assertEquals(1, th.getMyTransportersAt(r1, t11).size());
        assertEquals(1, th.getMyTransportersAt(r1, t22).size());

        assertEquals(1, th.getMyTransportersAt(r2, t11).size());
        assertEquals(1, th.getMyTransportersAt(r2, t22).size());

        assertEquals(0, th.getMyTransportersAt(none, t11).size());
        assertEquals(0, th.getMyTransportersAt(none, t22).size());

    }

    @Test
    public void remove() throws Exception {
        assertEquals(0, th.getTransportersAt(none).size());
        assertEquals(2, th.getTransportersAt(r1).size());
        assertEquals(1, th.getTransportersAt(r2).size());

        assertEquals(1, th.getMyTransportersAt(r1, t11).size());
        assertEquals(1, th.getMyTransportersAt(r1, t22).size());

        assertEquals(1, th.getMyTransportersAt(r2, t11).size());
        assertEquals(0, th.getMyTransportersAt(r2, t22).size());

        assertEquals(0, th.getMyTransportersAt(none, t11).size());
        assertEquals(0, th.getMyTransportersAt(none, t22).size());

        th.remove(t11, r1);

        assertEquals(0, th.getTransportersAt(none).size());
        assertEquals(1, th.getTransportersAt(r1).size());
        assertEquals(1, th.getTransportersAt(r2).size());

        assertEquals(0, th.getMyTransportersAt(r1, t11).size());
        assertEquals(1, th.getMyTransportersAt(r1, t22).size());

        assertEquals(1, th.getMyTransportersAt(r2, t11).size());
        assertEquals(0, th.getMyTransportersAt(r2, t22).size());

        assertEquals(0, th.getMyTransportersAt(none, t11).size());
        assertEquals(0, th.getMyTransportersAt(none, t22).size());
    }

    @Test
    public void move() throws Exception {
        assertEquals(0, th.getTransportersAt(none).size());
        assertEquals(2, th.getTransportersAt(r1).size());
        assertEquals(1, th.getTransportersAt(r2).size());

        assertEquals(1, th.getMyTransportersAt(r1, t11).size());
        assertEquals(1, th.getMyTransportersAt(r1, t22).size());

        assertEquals(1, th.getMyTransportersAt(r2, t11).size());
        assertEquals(0, th.getMyTransportersAt(r2, t22).size());

        assertEquals(0, th.getMyTransportersAt(none, t11).size());
        assertEquals(0, th.getMyTransportersAt(none, t22).size());

        th.move(t11, r1, none);

        assertEquals(1, th.getTransportersAt(none).size());
        assertEquals(1, th.getTransportersAt(r1).size());
        assertEquals(1, th.getTransportersAt(r2).size());

        assertEquals(0, th.getMyTransportersAt(r1, t11).size());
        assertEquals(1, th.getMyTransportersAt(r1, t22).size());

        assertEquals(1, th.getMyTransportersAt(r2, t11).size());
        assertEquals(0, th.getMyTransportersAt(r2, t22).size());

        assertEquals(1, th.getMyTransportersAt(none, t11).size());
        assertEquals(0, th.getMyTransportersAt(none, t22).size());
    }

}