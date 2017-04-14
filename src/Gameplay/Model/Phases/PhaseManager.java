package Gameplay.Model.Phases;

public class PhaseManager {
    private PhaseState currentState;

    public void advancePhase(){
        currentState.advance();
    }

    private class TradingPhase implements PhaseState{

        @Override
        public void advance() {
            currentState = new ProductionPhase();
        }
    }
    private class ProductionPhase implements PhaseState{

        @Override
        public void advance() {
            currentState = new BuildingPhase();
        }
    }
    private class BuildingPhase implements PhaseState{

        @Override
        public void advance() {
            currentState = new MovementPhase();
        }
    }
    private class MovementPhase implements PhaseState{

        @Override
        public void advance() {
            currentState = new WonderPhase();
        }
    }
    private class WonderPhase implements PhaseState{

        @Override
        public void advance() {
            currentState = new TradingPhase();
        }
    }
}
