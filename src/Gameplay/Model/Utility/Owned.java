package Gameplay.Model.Utility;


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
