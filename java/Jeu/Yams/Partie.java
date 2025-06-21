// Source file: C:/WINDOWS/Bureau/Prototype/Java/Jeu/Jeu/Partie.java

package Jeu;

import Core.Core;
import Figure.IFigure;
import Hasard.IHasardAppli;

import java.io.IOException;

import GUI.UIPartie;

public class Partie extends Core {
    private int nbJoueurs;
    private int nbFigures;
    
    int joueurCourant = 0;
    int nbtoursjoues = 0;
    
    public IHasardAppli m_IHasardAppli;
    
    public TableScore m_TableScore[];
    
    public UIPartie m_UIPartie;
    
    Partie() {
    }
    /**
       @roseuid 3BB20412017C
     */
    public Partie(int nbJoueurs, IFigure[] interfFigures, IHasardAppli iHasard) {
        this.nbJoueurs = nbJoueurs;
        this.nbFigures = interfFigures.length;
        m_TableScore = new TableScore[nbJoueurs];
        for (int i = 0; i < nbJoueurs; i++) 
            m_TableScore[i] = new TableScore(nbFigures, interfFigures);
        // <jux:Comment>
        // iHasard est partagé par toutes les parties.
        // Gestion du partage : Jeu.iHasard[]
        // </jux:Comment>
        m_IHasardAppli = iHasard;
    }
  
    public void setInterface(UIPartie interfaceUtilisateur) {
        m_UIPartie = interfaceUtilisateur;
    }
    /**
       @roseuid 3BB204120180
     */
    public boolean inscrireScore(int nbJoueur, int score) {
        return(m_TableScore[nbJoueur].setScore(score));
    }
    // Inscription du score et passage au joueur suivant
    public boolean validerScore() {
        int indScore = m_UIPartie.getSelection(joueurCourant);
        boolean inscrit = m_TableScore[joueurCourant].setScore(indScore);

        if (!inscrit) return(false); // Exception
        
        m_UIPartie.setScore(joueurCourant, indScore, m_TableScore[joueurCourant].evaluerScore(indScore));
        m_UIPartie.disableValider();
        m_UIPartie.showTotal(joueurCourant, getTotal(joueurCourant));
        
        if (!m_UIPartie.disableScore(joueurCourant)) {
            if (joueurCourant == nbJoueurs - 1) {
                System.out.println("****** FIN PARTIE *********");
                return (inscrit);
            }
        }

        joueurCourant = (joueurCourant + 1) % nbJoueurs;
        m_UIPartie.resetHasard();
        m_UIPartie.enableLancer();
        nbtoursjoues = 0;
        
        return(inscrit);
    }
    
    public int getJoueurCourant() {
        return (joueurCourant);
    }
    public void setJoueurCourant(int joueur) {
        this.joueurCourant = joueur;
    }
    public void setHasard(boolean[] garder) {
      int nbTours = 3;
        System.out.println("Joueur : " + joueurCourant);
        if (++nbtoursjoues == nbTours) {
            m_UIPartie.disableHasard();
            m_UIPartie.disableLancer();
            nbtoursjoues = 0;
        }
        else if (nbtoursjoues == 1) {
            m_UIPartie.enableHasard();
            m_UIPartie.enableScore(joueurCourant);
        }
            
        m_IHasardAppli.setGarder(garder);
        for (int i = 0; i < 5; i++) System.out.println("Garder : " + garder[i]);
        System.out.println("Lancer");
        m_IHasardAppli.set();
        
        // Sortie Systeme
        // m_IHasardAppli.afficher();
        m_UIPartie.setHasard(m_IHasardAppli.get());
        
        m_IHasardAppli.reset();
    }
    
    public int evaluerScore(int indScore) {
        m_UIPartie.enableValider();
        return(m_TableScore[joueurCourant].evaluerScore(indScore));
    }
    /**
       @roseuid 3BB636A400A0
     */
    public void jouer() {
       int choix;
      int nbTours = 3;
      boolean[] valGardes = new boolean[5];

      for (int nbFigJoue = 0; nbFigJoue < nbFigures; nbFigJoue++)
        // for (j = 0; j < nbJoueurs; j++)
        for (int j = 0; j < nbJoueurs; j++) {
          // Button:bLancer.activer declecnche l'appel suivant
          System.out.println("Joueur : " + j);
          m_IHasardAppli.set();
          m_IHasardAppli.afficher();

            for (int k = 0; k < nbTours - 1; k++) {
                boolean[] garder = garder();
                boolean garderTout = true;
                for (int l = 0; l < garder.length; l++)
                    if (garder[l] == false) {
                        garderTout = false; break;
                    }
                if (garderTout) break;
                    
                m_IHasardAppli.setGarder(garder);
                System.out.println("Lancer");
                m_IHasardAppli.set();
                m_IHasardAppli.afficher();
                m_IHasardAppli.reset();
            }

          do
            choix = choisirFigure();
	      while (!inscrireScore(j, choix));

	      
          System.out.println("Score : " + getScore(j, choix));
	      
	    }

        for (int j = 0; j < nbJoueurs; j++)
          System.out.println("Score total: " + getTotal(j));
	        
	    terminer();
    }
    
    /**
       @roseuid 3BB204120184
     */
    public int getScore(int joueur, int score) {
        return(m_TableScore[joueur].getScore(score));
    }
    
    /**
       @roseuid 3BB204120187
     */
    public int getTotal(int joueur) {
        return(m_TableScore[joueur].total());
    }
    
    /**
       @roseuid 3BB204120189
     */
    public void afficherScores() {
    }
    
    /**
       @roseuid 3BB636ED028A
     */
    public boolean[] garder() {
        int i;
        int nbVals = 5;
        boolean[] valGardes = new boolean[nbVals];
        System.out.println("Des a garder (6: garder tout, 0: terminer)");
        do
            try {
                i = System.in.read() - '0';
                
                System.in.read() ;
                System.in.read() ;
                // System.out.println(i);
                if (i == 0) return (valGardes);
                if (i == 6) {
                    for (i = 0; i < 5; i++) valGardes[i] = true;
                    return (valGardes);
                }
                valGardes[i-1] = true;
            } catch(IOException ioe) { while(true);}
        while (true);
    }
    
    /**
       @roseuid 3BB636ED028B
     */
    public int choisirFigure() {
        int fig = 0;
        
        System.out.println("Choisir Figure");
                
        try {       
            fig  = (System.in.read() - '0') * 10;
            fig += System.in.read() - '1';
            
            System.in.read() ;
            System.in.read() ;
            
        } catch(IOException ioe) {}
        return (fig);
    }
    
    /**
       @roseuid 3BB6371D0140
     */
    public void terminer() {
        try {                   
            System.in.read() ;
            System.in.read() ;
            
        } catch(IOException ioe) {}
    }
}
