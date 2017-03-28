package Model.Utility.MapParsers;

import Model.Map.BuildMap;
import Model.Map.PlacementManager;
import Model.ModelFacade;
import Model.Terrain.TerrainType;
import Model.Tile.BuildTile;
import Model.Tile.BuildTileFactory;
import Model.Utility.HexLocation;
import org.junit.Test;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FileChooserUI;

import java.awt.*;
import java.lang.reflect.Method;
import java.util.*;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jordi on 3/27/2017.
 */
public class DaveBuilderTest {

    /**
     * setup reflection
     */
    BuildMap map = BuildMap.getInstance();
    DaveBuilder daveBuilder;
    Class r = DaveBuilder.class;
    Class[] methodParameters;
    Object[] params;

    @Test
    public void saveMap1() throws Exception {

    }

    @Test
    public void cleanString() throws Exception {
        ModelFacade.initialize(new PlacementManager());
        daveBuilder = new DaveBuilder();

        methodParameters = new Class[]{String.class};
        params = new Object[]{new String("()())()")};

        Method m = r.getDeclaredMethod("cleanString", methodParameters);
        m.setAccessible(true);

        String cleanString = (String) m.invoke(daveBuilder, params);
        assertEquals("", cleanString);
    }

    @Test
    public void extractTilesInfo() throws Exception {
        ModelFacade.initialize(new PlacementManager());
        daveBuilder = new DaveBuilder();

        methodParameters = new Class[]{String[].class};
        params = new Object[]{new String[]{"numberOfTiles", "0 0 0 pasture 0 1 2", "1 1 0 woods 0 1 2", "2 2 0 rock 0"}};

        Method m = r.getDeclaredMethod("extractTilesInfo", methodParameters);
        m.setAccessible(true);

        List<DaveBuilderTile> daveBuilders = (java.util.List) m.invoke(daveBuilder, params);

        assertEquals("DaveBuilderTile{cubeLocation=(0, 0, 0), terrain='pasture', rivers=[0, 1, 2]}", daveBuilders.get(0).toString());
        assertEquals("DaveBuilderTile{cubeLocation=(1, 1, 0), terrain='woods', rivers=[0, 1, 2]}", daveBuilders.get(1).toString());
        assertEquals("DaveBuilderTile{cubeLocation=(2, 2, 0), terrain='rock', rivers=[0]}", daveBuilders.get(2).toString());

    }

    @Test
    public void convertToOddQOffset() throws Exception {
        ModelFacade.initialize(new PlacementManager());
        DaveBuilder daveBuilder = new DaveBuilder();

        Class r = DaveBuilder.class;

        Class[] methodParameters = new Class[]{CubeLocation.class};
        Object[] params = new Object[]{new CubeLocation(-0, 0, 0)};

        Method m = r.getDeclaredMethod("convertToOddQOffset", methodParameters);

        m.setAccessible(true);

        HexLocation hex = (HexLocation) m.invoke(daveBuilder, params);
        assertEquals("(10, 10)", hex.toString());

        params = new Object[]{new CubeLocation(5, -14, 9)};
        hex = (HexLocation) m.invoke(daveBuilder, params);
        assertEquals("(21, 15)", hex.toString());


        params = new Object[]{new CubeLocation(-2, -10, -1)};
        hex = (HexLocation) m.invoke(daveBuilder, params);
        assertEquals("(8, 8)", hex.toString());


        params = new Object[]{new CubeLocation(-3, -10, 0)};
        hex = (HexLocation) m.invoke(daveBuilder, params);
        assertEquals("(8, 7)", hex.toString());

        params = new Object[]{new CubeLocation(-4, -10, 0)};
        hex = (HexLocation) m.invoke(daveBuilder, params);
        assertEquals("(8, 6)", hex.toString());

        params = new Object[]{new CubeLocation(-10, -6, 16)};
        hex = (HexLocation) m.invoke(daveBuilder, params);
        assertEquals("(21, 0)", hex.toString());

        params = new Object[]{new CubeLocation(11, 4, -15)};
        hex = (HexLocation) m.invoke(daveBuilder, params);
        assertEquals("(0, 21)", hex.toString());
    }

    @Test
    public void convertToCube() throws Exception {
        ModelFacade.initialize(new PlacementManager());
        DaveBuilder daveBuilder = new DaveBuilder();

        Class r = DaveBuilder.class;

        Class[] methodParameters = new Class[]{Integer.TYPE, Integer.TYPE};
        Object[] params = new Object[]{new Integer(0), new Integer(0)};

        Method m = r.getDeclaredMethod("convertToCube", methodParameters);

        m.setAccessible(true);

        CubeLocation cube = (CubeLocation) m.invoke(daveBuilder, params);
        assertEquals("(-10, 15, -5)", cube.toString());

        params = new Object[]{new Integer(10), new Integer(10)};
        cube = (CubeLocation) m.invoke(daveBuilder, params);
        assertEquals("(0, 0, 0)", cube.toString());

        params = new Object[]{new Integer(21), new Integer(15)};
        cube = (CubeLocation) m.invoke(daveBuilder, params);
        assertEquals("(5, -14, 9)", cube.toString());

        params = new Object[]{new Integer(21), new Integer(0)};
        cube = (CubeLocation) m.invoke(daveBuilder, params);
        assertEquals("(-10, -6, 16)", cube.toString());

        params = new Object[]{new Integer(0), new Integer(21)};
        cube = (CubeLocation) m.invoke(daveBuilder, params);
        assertEquals("(11, 4, -15)", cube.toString());
    }

    @Test
    public void buildMap() throws Exception {
        ModelFacade.initialize(new PlacementManager());
        DaveBuilder daveBuilder = new DaveBuilder();

        while (true) {
            try {
//                daveBuilder.buildMap();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void formatTiles() throws Exception {
        ModelFacade.initialize(new PlacementManager());
        daveBuilder = new DaveBuilder();

        List<DaveBuilder> d= new ArrayList<>();
        Class[] methodParameters = new Class[]{ List.class};
        List<Integer> l1 = new ArrayList<>();
        l1.add(0);
        l1.add(0);
        l1.add(0);

        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        CubeLocation cubeLocation = new CubeLocation(0, 0, 0);
        CubeLocation cubeLocation1 = new CubeLocation(0, 3, 2);
        List<DaveBuilderTile> list= new ArrayList<>();
        list.add(new DaveBuilderTile(cubeLocation, "pasture", l1));
        list.add(new DaveBuilderTile(cubeLocation1, "mountain", l2));


        Object[] params = new Object[]{list};

        Method m = r.getDeclaredMethod("formatTiles", methodParameters);

        m.setAccessible(true);

        String output = (String) m.invoke(daveBuilder, params);

        String expectedResult = "2\n" +
                "(0 0 0) pasture (0 0 0 )\n" +
                "(0 3 2) mountain (1 )\n";

        assertEquals(expectedResult, output);
    }

    @Test
    public void saveMap() throws Exception {
        ModelFacade.initialize(new PlacementManager());
        daveBuilder = new DaveBuilder();
        BuildTileFactory tileFactory= new BuildTileFactory();
        BuildTile desert= tileFactory.createTile(TerrainType.DESERT.toString(), new int[] {2,3,5});
        BuildTile mountain= tileFactory.createTile(TerrainType.MOUNTAIN.toString(), new int[] {});
        BuildTile pasture= tileFactory.createTile(TerrainType.PASTURE.toString(), new int[] {2,3});
        BuildTile rock= tileFactory.createTile(TerrainType.ROCK.toString(), new int[] {2});

        map.addTile(desert, new HexLocation(0,0));
        map.addTile(rock, new HexLocation(10,10));
        map.addTile(mountain, new HexLocation(10,15));
        map.addTile(pasture, new HexLocation(11,10));
        map.addTile(rock, new HexLocation(12,10));

//        daveBuilder.saveMap(map);

    }

}