package Gameplay.Model.Phases;

import Gameplay.Model.Utility.Actions.Action;

import java.util.List;

public class PhaseManager {
    private PhaseState currentState;

    public void advancePhase(){
        currentState.advance();
    }

    private class TradingPhase extends PhaseState{

        @Override
        public void advance() {
            currentState = new ProductionPhase();
        }

        @Override
        protected List<Action> getActions() {
            return null;
        }
    }
    private class ProductionPhase extends PhaseState {

        @Override
        public void advance() {
            currentState = new BuildingPhase();
        }

        @Override
        protected List<Action> getActions() {
            return null;
        }
    }
    private class BuildingPhase extends PhaseState {

        @Override
        public void advance() {
            currentState = new MovementPhase();
        }

        @Override
        protected List<Action> getActions() {
            return null;
        }
    }
    private class MovementPhase extends PhaseState {

        @Override
        public void advance() {
            currentState = new WonderPhase();
        }

        @Override
        protected List<Action> getActions() {
            return null;
        }
    }
    private class WonderPhase extends PhaseState {

        @Override
        public void advance() {
            currentState = new TradingPhase();
        }

        @Override
        protected List<Action> getActions() {
            return null;
        }
    }
}
