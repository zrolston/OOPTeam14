package Controllers.ButtonListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import Model.ModelFacade;
import Model.Map.BuildMap;
import Model.Utility.FileIO;

/**
 * Created by Willie on 3/28/2017.
 */
public class SaveButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        ModelFacade modelFacade= ModelFacade.getInstance();
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Save Map");
        chooser.setFileFilter(new FileFilter() {
			@Override
			public boolean accept(File file) {
				if (file.isDirectory()) {
			           return true;
			       } else {
			           String filename = file.getName().toLowerCase();
			           return filename.endsWith(".dave");
			       }
			}

			@Override
			public String getDescription() {
				return "Dave Map File (*.dave)";
			}
    	});
        chooser.setCurrentDirectory(new File(FileIO.mapsDir));
        chooser.setVisible(true);
        String path = null;
        if (chooser.showSaveDialog(chooser) == JFileChooser.APPROVE_OPTION) {
            path = chooser.getSelectedFile().getAbsolutePath();
            modelFacade.saveMap (BuildMap.getInstance(),path);
        }
    }
}
