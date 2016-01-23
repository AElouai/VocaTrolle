/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static jdk.nashorn.internal.objects.NativeArray.map;

/**
 *
 * @author C#
 */
public class Varaibles {
    
    private static final Varaibles INSTANCE = new Varaibles();
    
    public static Varaibles instance() {
        return INSTANCE;
    }
    
    /*Path to the word list */
    public static int OptionSize = 10;
    public static String optionword;
    public static int tentative ;
    public static boolean ingame= false;
    public static String lang = "EN"; 
    
    public static String wordpathFR = "C:\\word\\WordFr.txt";
    public static String wordpathEN = "C:\\word\\WordEn.txt";
    public static String wordpathAR = "C:\\word\\WordAr.txt";
    public static String wordpathES = "C:\\word\\WordEs.txt";

    public static int score = 0 ;
    
    public static String currentWord;    
    
    public static ArrayList<String> WordList = new ArrayList<>();

}
