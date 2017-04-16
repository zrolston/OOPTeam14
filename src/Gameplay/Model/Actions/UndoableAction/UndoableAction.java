package Gameplay.Model.Actions.UndoableAction;

import Gameplay.Model.Actions.Action;

/**
 * Created by Willie on 4/15/2017.
 */
public interface UndoableAction extends Action {
    void undo();
}
