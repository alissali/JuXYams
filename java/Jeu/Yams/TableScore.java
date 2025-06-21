// Source file: C:/WINDOWS/Bureau/Prototype/Java/Jeu/Jeu/TableScore.java

package Jeu;

import Core.Core;
import Figure.IFigure;


public class TableScore extends Core {
    protected int nbFigures;
    private int[] score;
    private boolean[] inscrit;
    public IFigure m_IFigure[];
    
    TableScore() {
    }
    /**
       @roseuid 3BB026820384
     */
    public TableScore(int nbFigures, IFigure[] interfFigures) {
        
        System.out.println(" TableScore");
        this.nbFigures = nbFigures;
        
        score = new int[nbFigures];
        inscrit = new boolean[nbFigures];
        
        this.m_IFigure = new IFigure[nbFigures];
        
        for (int i = 0; i < nbFigures; i++) {
            this.m_IFigure[i] = interfFigures[i];
            inscrit[i] = false;
        }
    }
    
    /**
       @roseuid 3BB029650140
     */
    public boolean setScore(int indScore) {
        System.out.println("indScore : " + indScore);
        
        if (!inscrit[indScore]) {
            score[indScore] = m_IFigure[indScore].getScore();
            System.out.println("score : " + score[indScore]);
            inscrit[indScore] = true;
            return(true);
        }

        return(false);
    }

    // exemple de navigation : pour afficher le score avant validation,
    // en cours de partie, TableScore est la seule classe associée é IFigure
    public int evaluerScore(int indScore) {
        return(m_IFigure[indScore].getScore());
    }
    /**
       @roseuid 3BB48B8B01B8
     */
    public void unsetScore(int indScore) {
        // throws ArrayIndexOutOfBoundsException
            inscrit[indScore] = false;
    }
    
    /**
       @roseuid 3BB02B1C0122
     */
    public int getScore(int indScore) {
        return(score[indScore]);
    }
    
    /**
       @roseuid 3BB02311023A
     */
    public int total() {
        System.out.println("Total");
        int total = 0;
        for(int i = 0; i < nbFigures; i++)
            total += getScore(i);
            // <Tache>
            // Obtenir les valeurs des paramétres de bonus du .xml
        return(total + bonus(6, 35, 63));
            // </Tache>
    }
    private int bonus(int nombre, int val, int seuil)
    {
        int sousTotal = 0;
        for(int i = nombre-1; i >= 0; i--) {
            sousTotal += getScore(i);
            if (sousTotal >= seuil) return(val);
        }
        return(0);
    }
    /**
       @roseuid 3BB0552B0226
     */
    public void afficher() {
    }
}
