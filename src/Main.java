import Gameplay.Controller.MainController;
import Gameplay.Model.TransporterFactory.*;
import Gameplay.Model.Transporters.LandTransporters.Donkey;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Model.Utility.PlayerID;
import Gameplay.Views.Display;
import Gameplay.Views.Utility.CursorState;
import Gameplay.Views.Utility.Executor;

public class Main {
    public static void main(String[] args) {
        Display display = new Display();
        MainController mainController = new MainController(display.getMainView());

        CursorState.executor = new MyExecuter();

    }

    static class MyExecuter implements Executor{
        private boolean executed = false;
        TransporterFactory factory = new SteamerFactory();
        Transporter t = factory.create();

        public MyExecuter(){
            t.setPlayerID(PlayerID.getNewPlayerID());
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
