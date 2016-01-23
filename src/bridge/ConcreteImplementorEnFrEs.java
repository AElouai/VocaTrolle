/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridge;

import java.util.Random;
import singleton.Constants;

/**
 *
 * @author C#
 */
public class ConcreteImplementorEnFrEs extends Implementor {

    @Override
    public String OptionWordImp(int taille) {
        String randomOption = new String();
        Random rand = new Random();
        int vtaille = taille/3;        
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
        return randomOption;
    }
}
