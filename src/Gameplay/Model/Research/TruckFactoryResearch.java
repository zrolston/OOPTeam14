package Gameplay.Model.Research;

import java.awt.event.ActionListener;

/**
 * Created by Willie on 4/15/2017.
 */
public class TruckFactoryResearch implements Research {
    @Override
    public String getType() {
        return "Trruck Factory";
    }

    @Override
    public ActionListener getListener() {
        return null;
    }
}
