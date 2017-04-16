package Gameplay.Model.Actions.UndoableAction;

import Gameplay.Model.Actions.Action;

/**
 * Created by jordi on 4/13/2017.
 */
public class MoveAction implements UndoableAction {
    @Override
    public void execute() {
        System.out.println("moved");
    }

    @Override
    public void undo() {

    }
}
