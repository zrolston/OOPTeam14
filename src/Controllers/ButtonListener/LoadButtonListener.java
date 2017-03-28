package Controllers.ButtonListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Willie on 3/28/2017.
 */
public class LoadButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        chooser.setVisible(true);
        File file = null;
        if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
            //TODO: load map
        }
    }
}
