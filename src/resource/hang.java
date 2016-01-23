/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import bridge.Abstraction;
import bridge.ConcreteImplementorArabic;
import bridge.ConcreteImplementorEnFrEs;
import bridge.Implementor;
import bridge.RefindeAbstraction;
import iterator.WordListIterator;
import singleton.Varaibles;
import singleton.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

/**
 *
 * @author C#
 */
public class hang extends Varaibles {
    
    Constants constants = Constants.instance();
            
    public int randomimgs(){
        Random rand = new Random();
        return rand.nextInt(Constants.imgs-1);
    }
    
    public int randomimgf(){
        Random rand = new Random();
        return rand.nextInt(Constants.imgf-1);
    }
    
    public void loadWords(String wordpath){
        WordList.clear();
        Path source = Paths.get(wordpath);
        //D for debugin
        System.out.println("Source path : "+ source.getFileName());
        //Charset charset = Charset.forName("ASCII");
        Charset charset = Charset.forName("UTF-8");        
        try (BufferedReader reader = Files.newBufferedReader(source, charset))
        {
                String line ;
                while ((line = reader.readLine()) != null) {
                        //D for debugin
                        //System.out.println(line);
                        WordList.add(line.trim().toLowerCase());
                }
        } catch (IOException e) {
                //D for debugin            
                System.out.println("error :"+e.getMessage());
                WordList.clear();
        }
        System.out.println("WordList : "+WordList.size() );
    }
    
    //Returns a random WOrD containing n lowercase letters.
    //At least n/3 the letters in word should be VOWELS.
    public String OptionWord(int taille){
        String randomOption = new String();
        Random rand = new Random();
        Implementor impA;
        //in english this is how we do it in english and frensh
        //i don't anything about Es so i will just add it later on 
        //Arabic is the mother of all language i will figure out a way 
        if(lang.equals("EN") || lang.equals("FR") || lang.equals("ES") ){
            /*int vtaille = taille/3;        
            String vow = (String) Constants.VOWELS;
            for (int i = 0; i < vtaille; i++) {
                char c;
                int j = rand.nextInt(vow.length());
                c = vow.charAt(j);
                randomOption = randomOption+c;            
            }

            String con = (String) Constants.CONSONANTS;
            for (int i = 0; i < taille - vtaille ; i++) {
                char c;
                int j = rand.nextInt(con.length());
                c = con.charAt(j);
                randomOption = randomOption+c;            
            }
            return randomOption;*/
            impA = new ConcreteImplementorEnFrEs();
            //Abstraction a = new RefindeAbstraction(impA);
            //return a.getWord(taille);
        }else {//if(lang.equals("AR")) // if not en or fr or es than it arabic :D
            /*String arb = (String) Constants.Arab;
            for (int i = 0; i < taille; i++){
                char c;
                int j = rand.nextInt(arb.length());
                c = arb.charAt(j);
                randomOption = randomOption+" "+c;            
            }
            return randomOption;
            */
            impA = new ConcreteImplementorArabic();
            //Abstraction a = new RefindeAbstraction(impA);
            //return a.getWord(taille);
        }
        Abstraction a = new RefindeAbstraction(impA);
        return a.getWord(taille);        
        //return "ERROR";
    }
    
    public void setOptionword(int s){
        optionword = OptionWord(s);
    }
    //if the word is on the list it return true , false otherwise 
    public boolean ValideWord(String word,String Option){
        //i need to make short that the word have every one from Option
        if(word.length()>Option.length())
            return false;
        for (int i = 0; i < word.length(); i++) {
            String str = ""+ word.charAt(i);
            if(!Option.contains(str)  ){
                return false;
            } else {
                Option.replace(word.charAt(i), ' ');
            }
        }
        return true;
    }
    
    public boolean lookforWord(String word) {
        WordListIterator WordIterator = new WordListIterator(WordList);
        iterator.Iterator it = WordIterator.createIterator();
        while(it.hasNext()){
            String next = it.next();
            if(next.equals(word))
                return true;
            //for debugin
            //System.out.println("-->"+next);
        }
        return false;
        
        //tha was my code but netbeans has something better to offer
        //return WordList.stream().anyMatch((next) -> (next.equals(word)));
    }
    public int score(String word){
        int loc=0;
        for (int i = 0; i < word.length(); i++) {
            loc += i *2;
        }
        return loc;
    }
    public boolean updateOption(String word,String option){

        for (int i = 0; i < word.length(); i++) {
            String str = ""+ word.charAt(i);
            if(option.contains(str)){
                option = option.replaceFirst(""+word.charAt(i), " ");
            }
        }
        optionword = option;
        System.out.println("-->"+option.trim().isEmpty()+"<---");
        return option.trim().isEmpty();
    }
    //for test
    /*
   	public static void main(String[] args) throws IOException {
            System.out.println("Start :");
            hang h = new hang();
            //test the load of 
            h.loadWords();
            //generation of random word of length XD so far it was easy
            System.out.println(h.OptionWord(10));
            System.out.println(h.ValideWord("hello", "AAL", WordList));
            System.out.println("Score :"+h.score("hello"));
        }*/
    
}
