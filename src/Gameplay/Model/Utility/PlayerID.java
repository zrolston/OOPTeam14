package Gameplay.Model.Utility;

public class PlayerID {

    private static final int NEUTRAL = 0;
    private static final int PLAYER1 = 1;
    private static final int PLAYER2 = 2;
    private static final String[] colors = {"WHITE", "ORANGE", "BLUE"};

    private String color;

    private static int  numPlayers = 0;
    private int id;

    private PlayerID(int i) {
        this.id = i;
    }

    private int getID(){
        return id;
    }

    public static PlayerID getPlayer1ID(){
        return new PlayerID(PLAYER1);
    }
    public static PlayerID getPlayer2ID(){
        return new PlayerID(PLAYER2);
    }
    public static PlayerID getNeutralPlayerID(){
        return new PlayerID(NEUTRAL);
    }

    public String getPlayerColor(){
        return colors[id];
    }

    public boolean matches(PlayerID playerID) {
        return this.id == playerID.getID() || this.id == NEUTRAL || playerID.getID() == NEUTRAL;
    }
}
