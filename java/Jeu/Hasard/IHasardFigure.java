// Source file: C:/WINDOWS/Bureau/Prototype/Java/Jeu/Hasard/IHasardFigure.java

package Hasard;

/**
   Operations sur JeuDes (généralisable).
 */
public interface IHasardFigure {
    
    /**
       @roseuid 3BB44D1A00BE
     */
    public int nbVals(int valeur);
    
    /**
       @roseuid 3BAD086D0354
     */
    public int min();
    
    /**
       @roseuid 3BAD086D0384
     */
    public int max();
    
    /**
       @roseuid 3BB03EEB037A
     */
    public int nbEgaux(int nbeg);
    
    /**
       @roseuid 3BB04C1302BC
     */
    public int somme();
    
    /**
       @roseuid 3BB0838A03A2
     */
    public boolean full();
}
