package Gameplay.Model.Research;

import java.awt.event.ActionListener;

/**
 * Created by Willie on 4/15/2017.
 */
public class MineShaftSpecializationResearch implements Research {
    @Override
    public String getType() {
        return "Mine Shaft Specialization";
    }

    @Override
    public ActionListener getListener() {
        return null;
    }
}
