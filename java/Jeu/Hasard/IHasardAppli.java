// Source file: C:/WINDOWS/Bureau/Prototype/Java/Jeu/Hasard/IHasardAppli.java

package Hasard;

/**
   Definition de l'interface du jeu permettant d'obtenir les valeurs
   qui determinent les figures. Dans le cas du Yams : interface avec 
   JeuDes.
 */
public interface IHasardAppli {
    
    /**
       @roseuid 3BAD08DB02BC
     */
    public void set();
    
    /**
       @roseuid 3BA3A5D4003C
     */
    public int[] get();
    
    /**
       @roseuid 3BB4AE5A0032
     */
    public void reset();
    
    /**
       @roseuid 3BAD08320213
     */
    public void setGarder(boolean[] garderDes);
    
    /**
       @roseuid 3BAD08320212
     */
    public void afficher();
}
