package Gameplay.Model.Research;

import java.awt.event.ActionListener;

/**
 * Created by Willie on 4/15/2017.
 */
public class OilRigResearch implements Research {
    @Override
    public String getType() {
        return "Oil Rigs";
    }

    @Override
    public ActionListener getListener() {
        return null;
    }
}
