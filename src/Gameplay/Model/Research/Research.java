package Gameplay.Model.Research;

import java.awt.event.ActionListener;

/**
 * Created by Willie on 4/15/2017.
 */
public abstract interface Research {
    String getType();
    ActionListener getListener();
}
