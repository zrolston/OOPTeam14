package Gameplay.Model.Utility;
/**
 * Created by zrgam_000 on 4/15/2017.
 */
public class PlayerID {

    private static final int NEUTRAL = 1;

    private static int  numPlayers = 0;
    int id;

    private PlayerID(int i) {
        id = i;
    }

    public int getID(){
        return id;
    }

    public static PlayerID getNewPlayerID(){
        return new PlayerID(++numPlayers);
    }

    public static PlayerID getNeutralPlayerID(){
        return new PlayerID(NEUTRAL);
    }

    public boolean matches(PlayerID playerID) {

        return this.id == playerID.getID() || this.id == NEUTRAL || playerID.getID() == NEUTRAL;
    }
}
