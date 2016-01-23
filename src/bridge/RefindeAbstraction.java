/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridge;

/**
 *
 * @author C#
 */
public class RefindeAbstraction extends Abstraction {

    public RefindeAbstraction(Implementor im) {
        super(im);
    }

    @Override
    public String getWord(int taille) {
        return impOperationIMP(taille);
    }
    
}
