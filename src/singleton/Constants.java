/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

import java.util.HashMap;
import java.util.Map;
import static jdk.nashorn.internal.objects.NativeArray.map;



/**
 *
 * @author C#
 */
public class Constants { 
    
    private static final Constants INSTANCE = new Constants();
    private Constants() {    }    
    
    public static Constants instance() {
        return INSTANCE;
    }
    
    /*Path to the word list */
    public static final String VOWELSFR = "aeiouâéè";    
    public static final String VOWELS = "aeiou";
    public static final String CONSONANTS = "bcdfghjklmnpqrstvwxyz";
    
    public static final String Arab = "ابدهوزحطيكلمنسعفصقرشتثخذضظغج"; 
    public static final int maxtentative = 8;
    
    public static final int imgs = 28;
    public static final int imgf = 16;
    
}
