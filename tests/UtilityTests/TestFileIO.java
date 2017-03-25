package UtilityTests;
/*--------------------------------------------------------------------------------------
|	TestFileIO Class: Created by Alejandro Chavez on 3/25/2017.
|---------------------------------------------------------------------------------------
|   Description: Tests File loading, saving, and future parsing functionality.
---------------------------------------------------------------------------------------*/

import Utility.FileIO;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestFileIO {

    @Test
    public void testFileLoad(){
        String data = FileIO.loadFileText("testRead.txt");
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" +
                "Duis auctor, odio molestie elementum euismod, tortor tortor tempus augue, bibendum venenatis elit metus quis felis.\n" +
                "Aenean risus nisi, commodo sit amet convallis eget, ultricies sit amet ante.\n" +
                "Nulla molestie, mi et dapibus sagittis, velit enim scelerisque elit, sed aliquam ligula nibh nec augue.", data);
    }

    @Test
    public void testFileSave(){
        String content  = "Extra content";
        FileIO.saveFileText("testWrite.txt", content);
        String data = FileIO.loadFileText("testWrite.txt");
        assertEquals(data, content);
    }
}
