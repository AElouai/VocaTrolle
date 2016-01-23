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
public class WordIterator implements Iterator {

    ArrayList<String> WordItem;
    int position =0;    
    
    public WordIterator(ArrayList<String> WordItem){
        this.WordItem = WordItem;
    }
    
    @Override
    public boolean hasNext() {
        if(position >= WordItem.size() || WordItem.get(position) == null)
            return false;
        else 
            return true;
    }

    @Override
    public String next() {
        String str = WordItem.get(position);
        position++;
        return str;
    }
    
    
}
