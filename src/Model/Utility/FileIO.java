package Model.Utility;
/**--------------------------------------------------------------------------------------
|	FileIO Class: Created by Alejandro Chavez on 3/26/2017.
|---------------------------------------------------------------------------------------
|   Description: Handles Input and Output from a file. Feel free to add any parsing
|   functionality or anything that may make sense in this class.
---------------------------------------------------------------------------------------*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileIO {

    public static final String workingDir = System.getProperty("user.dir");
    public static final String mapsDir = workingDir + "/res/SavedMaps/";

    //Straight up loads text from a file
    //Note: Does NOT do any other parsing. Loads from SavedMaps folder
    public static String loadFileText(String fileName){
        String result = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader( fileName));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("|");
//                sb.append("\n");
                line = br.readLine();
            }
            br.close();
            result = sb.toString();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return result.substring(0, result.length()-1);
    }


    //Just saves text in a file based on fileName and content. Substitutes whatever the file had before
    //Note: Does NOT save text in any specific format. Loads from SavedMaps folder
    public static void saveFileText(String path, String content){
        try(PrintWriter out = new PrintWriter(path)) {
            out.print(content);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
