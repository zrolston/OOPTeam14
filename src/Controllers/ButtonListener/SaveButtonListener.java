package Controllers.ButtonListener;

import Model.Map.BuildMap;
import Model.ModelFacade;
import Model.Utility.FileIO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Willie on 3/28/2017.
 */
public class SaveButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        ModelFacade modelFacade= ModelFacade.getInstance();
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(FileIO.mapsDir));
        chooser.setVisible(true);
        String path = null;
        if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {
            path= chooser.getSelectedFile().getAbsolutePath();
            modelFacade.saveMap (BuildMap.getInstance(),path);
            //TODO: save map
        }
    }
}
