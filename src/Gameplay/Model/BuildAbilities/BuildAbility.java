package Gameplay.Model.BuildAbilities;

import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Utility.Owned;

/**
 * Created by zrgam_000 on 4/16/2017.
 */
public abstract class BuildAbility extends Owned {
    private UserRequest input;
    private Region placement;

    public abstract void build(UserRequest ur);

    public UserRequest getInput() {
        return input;
    }

    public Region getPlacement() {
        return placement;
    }
}
