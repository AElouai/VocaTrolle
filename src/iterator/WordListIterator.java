/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterator;

import java.util.ArrayList;

/**
 *
 * @author C#
 */
public class WordListIterator {

    ArrayList<String> WordList ;
    public WordListIterator(ArrayList<String> WordList) {
        this.WordList = WordList;
    }
    
    public Iterator createIterator(){
        return new WordIterator(WordList);
    } 
}
