package MapBuilder.Controllers.ButtonListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import MapBuilder.Model.ModelFacade;
import MapBuilder.Model.Map.BuildMap;
import MapBuilder.Model.Utility.FileIO;
import MapBuilder.Views.MapEditor.MapEditorView;
import MapBuilder.Views.MapEditor.MapView.MapSubsectionView;

/**
 * Created by Willie on 3/28/2017.
 */
public class LoadButtonListener implements ActionListener {
    private ModelFacade modelFacade = ModelFacade.getInstance();
    private MapSubsectionView mapSubsectionView;
    private MapEditorView mapEditorView;
    
    public LoadButtonListener(MapSubsectionView view, MapEditorView mapEditorView) {
        mapSubsectionView = view;
        this.mapEditorView = mapEditorView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Load Map");
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
        String path= null;
        if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {
            path= chooser.getSelectedFile().getAbsolutePath();
            modelFacade.loadMap(path);
            mapSubsectionView.updateCachedImages(BuildMap.getInstance());
            mapEditorView.updateImages();
        }
    }
}
