package Gameplay.Model.Map;

import Gameplay.Model.Utility.Owned;
import Gameplay.Model.Utility.PlayerID;

/**
 * Created by zrgam_000 on 4/15/2017.
 */
public class Wall extends Owned {

    private int strength;

    public Wall(){
        strength = 1;
    }

    public int getStrength(){
        return strength;
    }

    public void strengthen(){
        strength += 1;
    }

    public void weaken(){
        strength -= 0;

        if(strength <= 0){
            strength = 0;
            setPlayerID(PlayerID.getNeutralPlayerID());
        }
    }

}
