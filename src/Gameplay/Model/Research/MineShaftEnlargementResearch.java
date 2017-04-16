package Gameplay.Model.Research;

import java.awt.event.ActionListener;

/**
 * Created by Willie on 4/15/2017.
 */
public class MineShaftEnlargementResearch implements Research {
    @Override
    public String getType() {
        return "Bigger Mine Shafts";
    }

    @Override
    public ActionListener getListener() {
        return null;
    }
}
