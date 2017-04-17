import Gameplay.Controller.MainController;
import Gameplay.Model.Game.Game;
import Gameplay.Model.TransporterFactory.*;
import Gameplay.Model.Transporters.LandTransporters.Donkey;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Model.Utility.PlayerID;
import Gameplay.Views.Display;
import Gameplay.Views.Utility.CursorState;
import Gameplay.Views.Utility.Executor;

public class RunGame {
    public static void main(String[] args) {
        Game game = new Game();
        game.runGame();
    }

    static class MyExecuter implements Executor{
        private boolean executed = false;
        TransporterFactory factory = new SteamerFactory();
        Transporter t = factory.create();

        public MyExecuter(){
            t.setPlayerID(PlayerID.getPlayer2ID());
        }

        @Override
        public void execute() {
            if(executed){
                GameModelFacade facade = GameModelFacade.getInstance();
                facade.move(CursorState.getInstance().getActiveRegion(), t);
//                t.resetMovement();
            }
            else{
                execute2();
            }
        }
        private void execute2(){
            GameModelFacade facade = GameModelFacade.getInstance();
            facade.transporterHandler.place(t, CursorState.getInstance().getActiveRegion());
            CursorState.getInstance().getActiveRegion().enterRegion(t);
            executed = true;
        }
    }
}
