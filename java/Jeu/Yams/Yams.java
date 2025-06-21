// Source file: C:/WINDOWS/Bureau/Prototype/Java/Jeu/Yams/Yams.java

package Yams;

import Jeu.Jeu;
import Jeu.Partie;
import Figure.Full;
import Figure.Suite;
import Figure.Option;
import Figure.Egalite;
import Figure.Somme;
import JeuDes.JeuDes;
import Figure.IFigure;

import XMLYams.XMLYams;

import GUI.UIJuXJeu;


public class Yams extends Jeu {
    public JeuDes m_JeuDes;
   
    Yams() {
        m_JeuDes = new JeuDes(5);
        super.setInterface(m_JeuDes);
        
    }
    /**
       @roseuid 3BB726070000
     */
    public Yams(String[] nomClasse, String[] nomClasseFigure, String[] nomFigure, int[] scoreFigure) {
        this();

        // <Modif>
        // Objet descJeu persistant !!!!!!!!!!
         // m_DescriptionJeu = new DescriptionJeu();
         int nbFigures = nomFigure.length;
         int nbClasses = nomClasse.length;

         for (int i = 0; i < nbFigures; i++) {
            System.out.println(" Figure " + i + " : " +  nomClasseFigure[i]
                + ", " + nomFigure[i] + ", " + scoreFigure[i]);
         }
         
         for (int i = 0; i < nbClasses; i++)
            System.out.println(" Classe " + i + " : " +  nomClasse[i]);
            // créer objetGenerique[i] a partir de nomClasse[i]
            
         m_IFigure = new IFigure[nbFigures];

    // cloner les objets generiques
    // m_IFigure[i] = objetGenerique[i].clone();
    // m_IFigure[i].set(altFigure[i], scoreFigure[i]);
         for (int i = 0; i < 6; i++)
            m_IFigure[i] = new Somme(i + 1, 0);
         for (int i = 6; i < 8; i++)
            m_IFigure[i] = new Suite(i + 1, 15 + 5 *(i-6));
            
         m_IFigure[8] = new Egalite(3, 25);
         
         m_IFigure[9] = new Full(10, 30);
            
         for (int i = 10; i < 12; i++)
            m_IFigure[i] = new Egalite(4 + (i-10), 40 + 10 *(i-10));

         m_IFigure[12] = new Option(1,  0);
         m_IFigure[13] = new Option(-1, 0);
    //</Modif>

    }
    public Partie nouvellePartie()  {
        int nbJoueurs = getJoueurs();
        
        return(creerPartie(nbJoueurs));
    }
    public void nouvellePartie(UIJuXJeu yui)  {
        int nbJoueurs = getJoueurs();
        
        // création d'une interface graphique associée à une partie
        yui.setUserInterface(creerPartie(nbJoueurs), nbJoueurs);
    }

    private int getJoueurs() {
        return(2);
    }
    private int getNbVals() {
        return(5);
    }
    /**
       @roseuid 3BB4CFA500AA
     */
    public static void main(String[] args) {
        
        XMLYams m_XMLYams = new XMLYams();
        try {
            m_XMLYams.parse(args);
        } catch (Exception e) {System.out.println("Erreur XML");}

        Yams unYams = new Yams(m_XMLYams.getNomClasse(), m_XMLYams.getNomClasseFigure(), m_XMLYams.getNomFigure(), m_XMLYams.getScoreFigure());
 
        int nbJoueurs = unYams.getJoueurs();

        int nbVals = unYams.getNbVals();

        UIJuXJeu m_UIJuXJeu = new UIJuXJeu(unYams, nbVals, m_XMLYams.getNomFigure());
        unYams.nouvellePartie(m_UIJuXJeu);
        m_UIJuXJeu.show();
/*
        // <Alt>       
        // Moniteur Systeme
        unYams.nouvellePartie().jouer();
        // </Alt>
*/
    }
}
