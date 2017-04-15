package Gameplay.Model.Phases;

import Gameplay.Model.Utility.Actions.Action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class PhaseState {
    private Set<Action> permissibleActions = new HashSet<>();

    public abstract void advance();
    protected abstract List<Action> getActions();

    protected boolean isPermissibleAction(Action action){
        return permissibleActions.contains(action);
    }

    protected void addActions(){
        permissibleActions.addAll(getActions());
    }
}
