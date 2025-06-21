// Source file: C:/WINDOWS/Bureau/Prototype/Java/Jeu/Jeu/Jeu.java

package Jeu;

import Figure.Figure;
import Figure.IFigure;
import Hasard.IHasardAppli;
import Hasard.IHasardFigure;
import Hasard.Hasard;

import GUI.UIJuXJeu;
import GUI.UIPartie;

/**
   Définition des régles du jeu.
   Il ne s'agit pas nécesairement d'un jeu  de dés.
 */
public class Jeu {
    protected int nbVal;
    protected int nbValGardes;
    protected int nbTours;
    public IFigure m_IFigure[];
    public IHasardAppli m_IHasardAppli;

    public Partie m_Partie[];
    private int partieCourante = -1;
    private static final int nbParties = 10;
    private static int nbPartiesActives = 0;
    
    public Jeu() {
        // Support multi-partie a revoir
        m_Partie = new Partie[nbParties];                    
    }
    /**
       @roseuid 3BB2121E02DA
     */
    public Partie creerPartie(int nbJoueurs) {
        partieCourante = nbPartiesActives;
        m_Partie[nbPartiesActives++] = new Partie(nbJoueurs, m_IFigure, m_IHasardAppli);
        return(m_Partie[partieCourante]);
    }

    public void supprimerPartie(int i) {
        m_Partie[i] = m_Partie[--nbPartiesActives];
    }
    
    /**
       @roseuid 3BB212360352
     */
    public void enregistrerPartie() {
    }
    
    /**
       @roseuid 3BB46164006E
     */
    public void jouer(Partie partie) {
        partie.jouer();
    }
    
    /**
       @roseuid 3BB3C6960370
     */
    public boolean inscrireScore(int partie, int joueur, int choix) {
       return(m_Partie[partie].inscrireScore(joueur, choix));
    }
    
    /**
       @roseuid 3BB3C85D00AA
     */
    public int getScore(int partie, int joueur, int score) {
        return(m_Partie[partie].getScore(joueur, score));
    }
    
    /**
       @roseuid 3BB475600280
     */
    public int getTotal(int partie, int joueur) {
        return(m_Partie[partie].getTotal(joueur));
    }
    
    /**
       @roseuid 3BB69F1F003C
     */
    public void setInterface(Hasard hasard) {
        // <Commentaire type = "code" langage = "java">
        // jouer appelle Hasard.set()
        // inscrireScore appelle Hasard.score()
        // d'ou la double interface
        m_IHasardAppli = hasard;
        Figure.s_IHasardFigure = hasard;
        // </Commentaire>

    }
    /**
       @roseuid 3BB37AD6033E
     */
     
    public static void main(String[] args) {
        //TODO : GUI also + choice ascii/GUI   -- Mon Sep 07 08:51:48 CEST 2015 @327 /Internet Time/
        
        System.out.println("Test");
        Jeu unJeu = new Jeu();
                                // Couples de valeurs testées
        int nbFig = 14;         // 14 1   6  6
        int nbJoueurs = 2;      // 1  10  3  1
        // Partie partie = creerPartie(2, 14);
        // int partie = unJeu.creerPartie(2, 14);
        
        // int partie = unJeu.creerPartie(10, 1);
        
        Partie partie = unJeu.creerPartie(nbJoueurs);
    
        unJeu.jouer(partie);
        
        // IHasard.get() --> figure
        // indFigure <-- choix utilisateur
        // m_IFigure[indFigure].getScore(figure);
        /*
             Une autre solution possible :
             if (IFigure[indFigure] == figure) score = score[indFigure];
             */
        
        // IHasard.get() --> figure
        // indScore <-- choix utilisateur
        // setScore(joueur, indScore, IFigure[indScore].getScore(figure));
        
        // Partie.jouer(nbJoueur);
                        
        /* 
        ** TEST OK ********************************************
        unJeu.inscrireScore(1, unJeu.choisirFigure(), figure);
        System.out.println("Score : " + unJeu.getScore(1,8));
        *******************************************************
        */
        
        /*
        //Raccourci :
        System.out.println("Score : " + unJeu.m_IFigure[4].getScore(figure));
        System.out.println("Score : " + unJeu.m_IFigure[5].getScore(figure));
        System.out.println("Score : " + unJeu.m_IFigure[6].getScore(figure));
        
        // OU en passant par Partie et TableScore
        unJeu.inscrireScore(0, 7, figure);
        unJeu.inscrireScore(0, 8, figure);
        unJeu.inscrireScore(1, unJeu.choisirFigure(), figure);
                
        unJeu.inscrireScore(0, 9, figure);
        System.out.println("Score : " + unJeu.getScore(0,7));
        System.out.println("Score : " + unJeu.getScore(0,8));
        System.out.println("Score : " + unJeu.getScore(0,9));
        
        // Multijoueur
        unJeu.inscrireScore(1, 10, figure);
        System.out.println("Score : " + unJeu.getScore(1,10));
        */
        
        
    }
    
    
}
