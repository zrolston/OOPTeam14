package Gameplay.Model.BuildAbilities.PlayerSpecific;

import Gameplay.Model.BuildAbilities.BuildAbility;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Utility.PlayerID;

/**
 * Created by zrgam_000 on 4/16/2017.
 */
public class BuildTruckFactory extends BuildAbility{
    public BuildTruckFactory(PlayerID id) {
        super(id);
    }

    @Override
    public void build(UserRequest ur) {

    }
}
