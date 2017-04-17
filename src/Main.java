import Gameplay.Controller.MainController;
import Gameplay.Views.Display;
import Gameplay.Views.Utility.CursorState;
import Gameplay.Views.Utility.Executor;

public class Main {
    public static void main(String[] args) {
        Display display = new Display();
        MainController mainController= new MainController(display.getMainView());

        CursorState.executor = new MyExecuter();

    }

    static class MyExecuter implements Executor{
        @Override
        public void execute() {
            System.out.println("Hi");
        }
    }
}
