// Source file: C:/WINDOWS/Bureau/Prototype/Java/Jeu/Hasard/Hasard.java

package Hasard;

import Core.Core;


public abstract class Hasard extends Core implements IHasardAppli, IHasardFigure {
    private int nbVals;
    private int[] val;
    private boolean[] garder;
    
    public Hasard() {
    }
    /**
       @roseuid 3BB443DE0096
     */
    public Hasard(int nbVals) {
        
        this.nbVals = nbVals;
        val = new int[nbVals];
        garder = new boolean[nbVals];
        
    }
    
    /**
       @roseuid 3BB30F79037A
     */
    public void set() {
        double tempValue;
        for (int i = 0; i < nbVals; i++)
            if (!garder[i]) {
                tempValue = Math.random() * 6;
                val[i] = (int) Math.floor(tempValue) + 1;
                System.out.println("val " + i + " : " + val[i]);
            }
    }
    
    /**
       @roseuid 3BB1D24A00E6
     */
    public int[] get() {
        return(val);
    }
    
    /**
       @roseuid 3BB4AF2C0136
     */
    public void reset() {
        for (int i = 0; i < nbVals; i++)
            garder[i] = false;

    }
    
    /**
       @roseuid 3BB1D24A0123
     */
    public void setGarder(boolean[] garderVal) {
        for (int i = 0; i < nbVals; i++)
            garder[i] = garderVal[i];
            
        for (int i = 0; i < nbVals; i++)
                System.out.println("garder Hasard " + i + " : " + garder[i]);
    }
    
    /**
       @roseuid 3BB44C7B0050
     */
    public int nbVals(int valeur) {
        int nb = 0;
        for (int i = 0; i < nbVals; i++)
            if (val[i] == valeur) nb++;
            
        return(nb);
    }
    
    /**
       @roseuid 3BB1D24A0154
     */
    public int min() {
        int min = val[0];
        for (int i = 1; i < nbVals; i++)
            if (val[i] < min) min = val[i];
            
        return(min);
    }
    
    /**
       @roseuid 3BB1D24A0155
     */
    public int max() {
        int max = val[0];
        for (int i = 1; i < nbVals; i++)
            if (val[i] > max) max = val[i];
            
        return (max);
    }
    
    /**
       @roseuid 3BB1D24A0190
     */
    public int nbEgaux(int nbeg) {
        int nbEgaux = 0;
        int maxNbEg = 0;
        
        for (int i = 0; i < nbVals; i++)
        {
            if (nbEgaux > maxNbEg) maxNbEg = nbEgaux;
            nbEgaux = 1;
            if ((nbVals - i) < nbeg)                    
                return(0);
                
                
            for (int j = i + 1; j < nbVals; j++) {  // tests d'egalite
                if ( val[j] == val[i]) {
                    nbEgaux++;
                    if ( (nbeg != 0) && (nbEgaux == nbeg))
                        return (nbEgaux);
                }
            }
        }
        System.out.println("maxNbEg : "  + maxNbEg);
        return(maxNbEg);
    }
    
    /**
       @roseuid 3BB1D24A0192
     */
    public int somme() {
        int som = 0;
        
        for (int i = 0; i < nbVals; i++)
            som += val[i];
        return(som);
    }
    
    /**
       @roseuid 3BB1D24A0193
     */
    public boolean full() {
        int prem = val[0];
        int dxm  = val[1];
        int nbPrem, nbDxm;
        for(int i = 1; i < nbVals; i++)
            if(val[i] != prem) {
                dxm = val[i];
                break;
            }
        nbPrem = nbVals(prem);
        if (nbPrem == nbVals) return(true);
        nbDxm  = nbVals(dxm);
        System.out.println("full() : " + nbPrem + " " + nbDxm); 
        if(((nbPrem == 3) && (nbDxm == 2)) ||
           ((nbPrem == 2) && (nbDxm == 3)))
           return(true);
           
        return(false);
    }
    
    /**
       @roseuid 3BB1D24A0122
     */
    public void afficher() {
        for (int i = 0; i < nbVals; i++)
            System.out.println (i+1 + " : " + val[i]);
        
    }
}
