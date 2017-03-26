/**-------------------------------------------------------------------------------------
|	MapSubsectionView Class: Created by Alejandro Chavez on 3/26/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/
package Views.MapEditor.MapView;

import Model.Map.IViewMap;
import Views.Utility.PixelMap;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MapSubsectionView extends JPanel {

    BufferedImage image;
    BufferedImage[][] tileImages;

    public void updateTileImages(IViewMap map) {
        //TODO: update tileImages with MapDrawingVisitor
    }

    public void updateImage() {
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        //TODO: update image with tileImages
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

    public MapSubsectionView() {
        setBounds(0, 0, PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);
        setBackground(Color.blue);
        setVisible(true);

        image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);

        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setColor( new Color(0xffCABD80)  );
        g2.fillRect( 0, 0, image.getWidth(), image.getHeight() );
    }
}
