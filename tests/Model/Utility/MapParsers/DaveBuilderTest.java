package Model.Utility.MapParsers;

import Model.Map.BuildMap;
import Model.ModelFacade;
import org.junit.Test;

import javax.swing.*;
import javax.swing.plaf.FileChooserUI;

import java.awt.*;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * Created by jordi on 3/27/2017.
 */
public class DaveBuilderTest {

    @Test
    public void saveMap1() throws Exception {

    }

    @Test
    public void parseData1() throws Exception {

    }

    @Test
    public void cleanString() throws Exception {

    }

    @Test
    public void extractTilesInfo() throws Exception {

    }

    @Test
    public void convertToOddQOffset() throws Exception {
        BuildMap map= BuildMap.getInstance();
        ModelFacade.initialize(map);
        DaveBuilder daveBuilder= new DaveBuilder();

        CubeLocation cubeLocation=new CubeLocation(1,2,3);
        

    }

    @Test
    public void convertToCube() throws Exception {

    }


    @Test
    public void parseData() throws Exception {
        BuildMap map= BuildMap.getInstance();
        ModelFacade.initialize(map);
        DaveBuilder daveBuilder= new DaveBuilder();
        JButton jButton = new JButton();
        final JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new java.io.File("./res/SavedMaps/"));
        fc.setDialogTitle("Test1");

        if (fc.showOpenDialog(jButton) == JFileChooser.APPROVE_OPTION) {
        }

        if (fc.getSelectedFile() != null) {
            daveBuilder.buildMap(fc.getSelectedFile().getAbsolutePath());

            System.out.println(fc.getSelectedFile().getAbsolutePath());
        }

        System.out.println("hello world");

//        int returnVal= fc.showOpenDialog(jButton);


    }

    @Test
    public void saveMap() throws Exception {

    }

}