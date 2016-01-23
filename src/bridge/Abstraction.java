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
public abstract class Abstraction {
    
    Implementor imp ;
    public Abstraction(Implementor im){
        imp = im;
    }
    public String impOperationIMP(int taille){
        return imp.OptionWordImp(taille);
    }
    
    abstract public String getWord(int taille);
    
    
}
