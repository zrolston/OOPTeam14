package Gameplay.Model.Research;

import java.awt.event.ActionListener;

/**
 * Created by Willie on 4/15/2017.
 */
public class RowboatFactoryResearch implements Research {
    @Override
    public String getType() {
        return "Rowboat Factory";
    }

    @Override
    public ActionListener getListener() {
        return null;
    }
}
