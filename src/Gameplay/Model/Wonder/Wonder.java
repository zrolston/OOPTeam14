package Gameplay.Model.Wonder;

import Gameplay.Model.Actions.WonderAction.IrrigationWonderAction;
import Gameplay.Model.Actions.WonderAction.WonderAction;

/**
 * Created by Willie on 4/17/2017.
 */
public class Wonder {

    Brick[] bricks;
    WonderAction[] wonderActions;
    int counter = 0;

    public Wonder() {
        bricks = new Brick[61];
        wonderActions = new WonderAction[61];
        wonderActions[44] = new IrrigationWonderAction();
    }

    public void addBrick(Brick brick) {
        bricks[counter] = brick;
        if (wonderActions[counter] != null)
            wonderActions[counter].execute();
        counter++;
    }

}
