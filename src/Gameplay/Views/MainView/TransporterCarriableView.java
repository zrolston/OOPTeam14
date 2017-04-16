package Gameplay.Views.MainView;

import Gameplay.Model.Visitors.Carriable;
import Gameplay.Views.Utility.PolygonUtility;
import MapBuilder.Views.Utility.ImageLoader;
import MapBuilder.Views.Utility.PixelMap;
import MapBuilder.Views.Utility.PixelPoint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;


public class TransporterCarriableView extends JPanel {

    private BufferedImage background;
    private ArrayList<Polygon> columns;
    private List<Rectangle> buttons;
    private List<Carriable> leftCarriables;
    private List<Carriable> rightCarriables;

    private int horizontalOffset, verticalOffset, buttonSide;

    public TransporterCarriableView() {
        setLayout(new BorderLayout());
        setBounds((int)(PixelMap.SCREEN_WIDTH * (1 - 34.0/40 - 1.0/7)), (int)(PixelMap.SCREEN_HEIGHT * .05), PixelMap.SCREEN_WIDTH /7, (int)(PixelMap.SCREEN_HEIGHT * (17.0/20 + 1.0/12 - .05)));
        setOpaque(false);
        setVisible( true );
        background = ImageLoader.getImage("SCROLL_BACKGROUND");

        int numElements = 11;
        int numCols = 2;
        int numRows = 8;

        columns = new ArrayList<>();
        int widthOffset = getWidth() / numCols;
        for (int i = 0; i < numCols; i++) {
            Polygon col = PolygonUtility.rectangleToPolygon(new Rectangle(i*widthOffset, 0, widthOffset, getHeight()));
            columns.add( col );
        }

        //Calculate the offsets
        horizontalOffset = (int)(0.15*(getWidth()/numCols));
        buttonSide = (int)(0.75*(getWidth()/numCols));
        verticalOffset = ((getHeight()-horizontalOffset-5-numRows*buttonSide)/numRows);

        //Initialize the left and right buttons
        buttons = new ArrayList<>();
        for(int i = 0; i <  numElements / numCols + 1; i++) {

            for (int j = 0; j < numCols; j++) {
                if( ( i * numCols + j)  >= numElements)
                    break;
                PixelPoint origin = new PixelPoint(horizontalOffset+getWidth()/numCols * j - 4, horizontalOffset+((buttonSide+verticalOffset)*i));
                buttons.add(PolygonUtility.generateSquare(origin, buttonSide));
            }

        }


        //Test Action Listener
        addMouseListener(new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                PixelPoint point = new PixelPoint(e.getX(), e.getY());
                int index = getCarriableIndex(point);
                System.out.println(index);
            }

            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }

    //Set the different Carriables Dynamically
    public void setLeftCarriables(List<Carriable> leftCarriables) { this.leftCarriables = leftCarriables; }
    public void setRightCarriables(List<Carriable> rightCarriables) { this.rightCarriables = rightCarriables; }

    protected void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, (int)(getWidth() * 1.145), (int)(getHeight()), null);
        super.paintComponent(g);
        drawColumns(g);
        drawButtons(g);
    }

    private void drawColumns(Graphics g){
        for (Polygon p :
                columns) {
            g.drawPolygon( p );
        }
    }

    private void drawButtons(Graphics g){
        for(Rectangle r: buttons) g.drawRoundRect((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight(), 5, 5);
    }

    public Integer getCarriableIndex(PixelPoint point){
        int index = 0;
        for(Rectangle button: buttons){
            //Checking right button list
            if(button.contains(point.getX(), point.getY()))
                return index;
            index++;
        }
        return -1;
    }


}
