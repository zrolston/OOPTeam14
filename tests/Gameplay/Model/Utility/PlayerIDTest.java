package Gameplay.Model.Utility;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zrgam_000 on 4/15/2017.
 */
public class PlayerIDTest {
    public PlayerID p1;
    public PlayerID p2;
    public PlayerID p3;

    @Before
    public void TestSetup(){
        p1 = PlayerID.getPlayer1ID();
        p2 = PlayerID.getPlayer1ID();
        p3 = PlayerID.getNeutralPlayerID();
    }

    @Test
    public void TestMatches(){
        assertTrue(p1.matches(p1));
        assertTrue(p2.matches(p2));
        assertFalse(p1.matches(p2));
        assertFalse(p2.matches(p1));

        assertTrue(p3.matches(p3));
        assertTrue(p3.matches(p1));
        assertTrue(p3.matches(p2));

        assertTrue(p1.matches(p3));

        assertTrue(p2.matches(p3));
    }
}