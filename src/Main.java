import Gameplay.Controller.MainController;
import Gameplay.Views.Display;

public class Main {
    public static void main(String[] args) {
        Display display = new Display();
        MainController mainController= new MainController(display.getMainView());
    }
}
