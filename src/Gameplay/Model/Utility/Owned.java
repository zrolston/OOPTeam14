package Gameplay.Model.Utility;

/**
 * Created by zrgam_000 on 4/15/2017.
 */
public abstract class Owned {
    PlayerID playerID;

    public PlayerID getPlayerID(){
        return playerID;
    }

    public void setPlayerID(PlayerID pid){
        playerID = pid;
    }

    public boolean matches(Owned owned){
        return playerID.matches(owned.getPlayerID());
    }
}
