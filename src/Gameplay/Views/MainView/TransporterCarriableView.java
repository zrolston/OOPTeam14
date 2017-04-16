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
    private Polygon leftColumn = null;
    private Polygon rightColumn = null;
    private List<Rectangle> leftButtons;
    private List<Rectangle> rightButtons;
    private List<Carriable> leftCarriables = new ArrayList<>();
    private List<Carriable> rightCarriables = new ArrayList<>();
    private int horizontalOffset, verticalOffset, buttonSide;

    public TransporterCarriableView() {
        setLayout(new BorderLayout());
        setBounds((int)(PixelMap.SCREEN_WIDTH * (1 - 34.0/40 - 1.0/7)), (int)(PixelMap.SCREEN_HEIGHT * .05), PixelMap.SCREEN_WIDTH /7, (int)(PixelMap.SCREEN_HEIGHT * (17.0/20 + 1.0/12 - .05)));
        leftColumn = PolygonUtility.rectangleToPolygon(new Rectangle(0, 0, getWidth()/2, getHeight()));
        rightColumn = PolygonUtility.rectangleToPolygon(new Rectangle(getWidth()/2, 0, getWidth()/2, getHeight()));

        setOpaque(false);
        setVisible( true );
        background = ImageLoader.getImage("SCROLL_BACKGROUND");

        //Calculate the offsets
        int number = 8;
        horizontalOffset = (int)(0.15*(getWidth()/2));
        buttonSide = (int)(0.75*(getWidth()/2));
        verticalOffset = ((getHeight()-horizontalOffset-5-number*buttonSide)/number);

        //Initialize the left and right buttons
        leftButtons = new ArrayList<>();
        rightButtons = new ArrayList<>();
        for(int i = 0; i<number; i++){
            PixelPoint origin = new PixelPoint(horizontalOffset, horizontalOffset+((buttonSide+verticalOffset)*i));
            leftButtons.add(PolygonUtility.generateSquare(origin, buttonSide));
            origin = new PixelPoint(horizontalOffset+getWidth()/2-4, horizontalOffset+((buttonSide+verticalOffset)*i));
            rightButtons.add(PolygonUtility.generateSquare(origin, buttonSide));
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
//        drawColumns(g);
        drawButtons(g);
    }

    private void drawColumns(Graphics g){
        g.drawPolygon(leftColumn);
        g.drawPolygon(rightColumn);
    }

    private void drawButtons(Graphics g){
        for(Rectangle r: leftButtons) g.drawRoundRect((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight(), 5, 5);
        for(Rectangle r: rightButtons) g.drawRoundRect((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight(), 5, 5);
    }

    public Integer getCarriableIndex(PixelPoint point){
        int index = 0;
        for(Rectangle button: leftButtons){
            //Checking left button list
            if(button.contains(point.getX(), point.getY()))
                return index;
            index++;
        }
        for(Rectangle button: rightButtons){
            //Checking right button list
            if(button.contains(point.getX(), point.getY()))
                return index;
            index++;
        }
        return -1;
    }


}
