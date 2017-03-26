package Views;


import javax.swing.*;

public class View {

    private Display displayScreen = null;

    public View() {
        // SwingUtilities.invokeLater causes the Runnable to be executed asynchronously on the Event Dispatch Thread:
        // It queues up a task (GUI update) on the EDT and instantly returns.
        // Used to prevent long tasks from freezing up the GUI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    // Create the GUI and show it.
    private void createAndShowGUI() {
        displayScreen = new Display();                       // setup new frame
    }

}
