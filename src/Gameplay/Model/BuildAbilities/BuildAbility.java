package Gameplay.Model.BuildAbilities;

import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Utility.Owned;
import Gameplay.Model.Utility.PlayerID;


public abstract class BuildAbility extends Owned {
    private UserRequest input;
    private Region placement;

    public BuildAbility(PlayerID id){
        setPlayerID(id);
    }

    public abstract void build(UserRequest ur);

    public UserRequest getInput() {
        return input;
    }

    public Region getPlacement() {
        return placement;
    }
}
