/**-------------------------------------------------------------------------------------
|	TileSelectionView Class: Created by Alejandro Chavez on 3/26/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/
package Views;

import Model.Utility.PixelMap;
import javax.swing.*;
import java.awt.*;

public class TileSelectionView extends JPanel{

    TileSelectionView(){
        setLayout(null);
        setBounds(PixelMap.TILE_WIDTH/2, PixelMap.TILE_HEIGHT/2, PixelMap.TILE_FULL_WIDTH*2, PixelMap.TILE_HEIGHT*5);
        System.out.println("Width: "+getWidth()+" -- Height: "+getHeight());
        setVisible(true);
    }

    @Override
    public void paint(Graphics g){
        super.paintComponent(g);
        ((Graphics2D)g).setStroke(new BasicStroke(3));
        g.drawRect(3,3,getWidth()-6, getHeight()-6);
    }
}
