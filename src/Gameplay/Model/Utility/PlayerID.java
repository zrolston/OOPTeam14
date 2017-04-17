package Gameplay.Model.Utility;

public class PlayerID {

    private static final int NEUTRAL = 0;

    private static int  numPlayers = 0;
    int id;

    private static String[] colors = {"WHITE", "BLUE", "RED"};
    private String color;

    public PlayerID(int i) {
        id = i;
        this.color = colors[i];
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

    public String getPlayerColor(){
        return color;
    }

    public boolean matches(PlayerID playerID) {

        return this.id == playerID.getID() || this.id == NEUTRAL || playerID.getID() == NEUTRAL;
    }
}
