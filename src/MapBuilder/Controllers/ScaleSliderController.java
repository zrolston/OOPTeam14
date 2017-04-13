package MapBuilder.Controllers;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import MapBuilder.Views.MapEditor.ScaleSliderView;
import MapBuilder.Views.MapEditor.MapView.MapSubsectionView;
import MapBuilder.Views.Utility.Camera;

/**
 * Created by Willie on 3/28/2017.
 */
public class ScaleSliderController implements ChangeListener {

    private MapSubsectionView mapSubsectionView;

    public ScaleSliderController(MapSubsectionView view) {
        mapSubsectionView = view;
    }

    public void stateChanged(ChangeEvent e) {

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                ScaleSliderView view = (ScaleSliderView) e.getSource();
//                Camera camera = Camera.getInstance();
//                int scale = view.getValue();
//                camera.setScale((double) scale / 10);
//
//                SwingUtilities.invokeLater(new Runnable() {
//                    @Override
//                    public void run() {
//                        mapSubsectionView.updateImage();
//                    }
//                });
//
//            }
//        }).start();

        ScaleSliderView view = (ScaleSliderView) e.getSource();
        Camera camera = Camera.getInstance();
        int scale = view.getValue();
        camera.setScale((double) scale / 10);
        mapSubsectionView.updateImage();

    }
}
