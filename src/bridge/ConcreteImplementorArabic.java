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
public class ConcreteImplementorArabic extends Implementor {

    @Override
    public String OptionWordImp(int taille) {
        String randomOption = new String();
        Random rand = new Random();
        String arb = (String) Constants.Arab;
            for (int i = 0; i < taille; i++){
                char c;
                int j = rand.nextInt(arb.length());
                c = arb.charAt(j);
                randomOption = randomOption+" "+c;            
            }
            return randomOption;
    }
    
}
