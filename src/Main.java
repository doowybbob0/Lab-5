import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;    //Importing stuff for JSON parsing
import com.google.gson.*;	
import java.io.*;
import java.util.*;



/**
 * Executive Main Class. Serves for Saving/Reading and Script Running purposes
 */
public class Main {
	
    /**
     * Asks user to fill in desired file path via environment variable
     */			

	public static String inputFilePath() throws FileNotFoundException {
		String filePath = System.getenv("filePath");
        if (filePath == null){
            return ("----\nПуть через переменную окружения filePath не указан\n----");
        } else {
                return filePath;
            }
    }


    private static void scriptExecution() throws IOException {
        OutputStream fff = new FileOutputStream("script");
        OutputStreamWriter oos = new OutputStreamWriter(fff);
        oos.write("help"+System.lineSeparator()+"info"+System.lineSeparator()+"insert_key"+System.lineSeparator()+"show");
        oos.close();
    }
    
    /**
     * Loads data from defined file location. Reads json file and then forms it in the collection.
     */	
    public static void loadJson(String localPath) throws FileNotFoundException, com.google.gson.JsonSyntaxException {    	
    	try {
	    	if (localPath==""){localPath=inputFilePath();}  //Asks user for path input via inputFilePath()
	    	    	
	    	Scanner scDefault = new Scanner(new File(localPath));
	    	String preloadedData = scDefault.nextLine();
	    	//System.out.println(preloadedData);
	    	Gson gsonHandler = new Gson();
	        SpaceMarineLists handledPreloadedList = gsonHandler.fromJson(preloadedData, SpaceMarineLists.class);
	        if (handledPreloadedList.SpaceMarineList !=null) {
	            CCollection.collectionBuffer.addAll(handledPreloadedList.SpaceMarineList);
	            //System.out.println(CCollection.collectionBuffer);
	            if (CCollection.collectionBuffer.size() <= 0) {System.out.println("=====This file's collection is empty=====");
	            System.out.println("Type raw_start to load prerecorded collection");}
	        }else {System.out.println("=====This file's collection is empty=====");
	        System.out.println("Type raw_start to load prerecorded collection");}
    	}catch (JsonSyntaxException eC){
    		System.out.println("[ERROR]: Your json file is corrupted (╯°□°）╯︵ ┻━┻");
    		System.out.println("...but you still can load default collection by typing in raw_start...");
    	}catch (FileNotFoundException eFNF){System.out.println("Unable to reach your file. Check your path and try again ");}         
    }    
    
    
    /**
     * This method runs the whole program
     */
    public static void main(String[] args) throws IOException {
    	
    	loadJson("Collection.json");  //loading collection. If empty, you should use environment variable filePath 
        CCollection.enscribing();        
        System.out.println("Type help for help, fellas");
        Control Lab = new Control(new CommandInput(""));
        Lab.Scan();
    }
}