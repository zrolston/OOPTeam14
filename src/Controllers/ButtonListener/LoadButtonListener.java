package Controllers.ButtonListener;

import Model.Map.BuildMap;
import Model.ModelFacade;
import Views.MapEditor.MapView.MapSubsectionView;
import Model.Utility.FileIO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Willie on 3/28/2017.
 */
public class LoadButtonListener implements ActionListener {
    ModelFacade modelFacade=ModelFacade.getInstance();

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Load Map");
        chooser.setCurrentDirectory(new File(FileIO.mapsDir));
        chooser.setVisible(true);
        String path= null;
        if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {
            path= chooser.getSelectedFile().getAbsolutePath();
            modelFacade.loadMap(path);
            MapSubsectionView.updateCachedImages(BuildMap.getInstance());
        }
    }
}
