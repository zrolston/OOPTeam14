package Gameplay.Model.Phases;

import Gameplay.Controller.MainController;
import Gameplay.Controller.PhaseStateController;
import Gameplay.Controller.PhaseStateControllers.*;
import Gameplay.Controller.PhaseStateControllers.MovementStateControllers.MovementPhaseStateController;


public class PhaseManager {
    private PhaseState currentState;

    private TradingPhase tradingPhase = new TradingPhase();
    private ProductionPhase productionPhase = new ProductionPhase();
    private MovementPhase movementPhase = new MovementPhase();
    private BuildingPhase buildingPhase = new BuildingPhase();
    private WonderPhase wonderPhase = new WonderPhase();
    private MainController mainController;

    public PhaseManager(MainController mainController) {
        this.mainController = mainController;
        currentState = tradingPhase;
        updateController();
    }

    public void advancePhase() {
        currentState.advance();
        updateController();
    }

    private void updateController() {
        mainController.setState(currentState.getPhaseController());
    }

    private class TradingPhase implements PhaseState {
        TradePhaseStateController tradeController = new TradePhaseStateController();

        @Override
        public void advance() {
            currentState = productionPhase;
        }

        @Override
        public PhaseStateController getPhaseController() {
            return tradeController;
        }
    }

    private class ProductionPhase implements PhaseState {
        ProductionPhaseStateController productionController = new ProductionPhaseStateController();

        @Override
        public void advance() {
            currentState = buildingPhase;
        }

        @Override
        public PhaseStateController getPhaseController() {
            return productionController;
        }

    }

    private class BuildingPhase implements PhaseState {
        BuildPhaseStateController buildController = new BuildPhaseStateController();

        @Override
        public void advance() {
            currentState = movementPhase;
        }

        @Override
        public PhaseStateController getPhaseController() {
            return buildController;
        }

    }

    private class MovementPhase implements PhaseState {
        MovementPhaseStateController movementController = new MovementPhaseStateController();

        @Override
        public void advance() {
            currentState = wonderPhase;
        }

        @Override
        public PhaseStateController getPhaseController() {
            return movementController;
        }


    }

    private class WonderPhase implements PhaseState {
        WonderPhaseStateController wonderController = new WonderPhaseStateController();

        @Override
        public void advance() {
            currentState = tradingPhase;
        }

        @Override
        public PhaseStateController getPhaseController() {
            return wonderController;
        }


    }
}
