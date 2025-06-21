// Source file: C:/WINDOWS/Bureau/Prototype/Java/AppliYams/GUI/UIPartie.java

package GUI;

import java.awt.Frame;
import java.awt.Button;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Jeu.Partie;

import java.awt.Color;
import java.awt.Font;

public class UIPartie extends Frame implements ActionListener {
    public UIHasard m_UIHasard;
    public Button bValider;
    public Button bLancer;
    public GridBagConstraints m_GridBagConstraints;
    public UITableScore m_UITableScore[];

    /*   // vert 
    private Color bColor = new Color(20, 80, 40);
    private Color couleurBord = new Color(0, 80, 20);
    private Color partieBG = new Color(10, 80, 60);
         // magenta
    private Color bColor = new Color(120, 40, 80);
    private Color couleurBord = new Color(60, 20, 40);
    private Color partieBG = new Color(120, 20, 80);
         // bleu
    private Color bColor = new Color(40, 80, 160);
    private Color couleurBord = new Color(10, 30, 40);
    private Color partieBG = new Color(20, 80, 120);
    */
    /* vert foncé
    private Color partieBG = new Color(60, 80, 60);
    */
    private Color bColor = new Color(15, 40, 80);
    private Color couleurBord = new Color(60, 220, 180);
    private Color partieBG = new Color(0, 40, 120);
 
    private Partie laPartie;
    
    private String[] nomFigure;
    UIPartie() {
    }
    /**
       @roseuid 3BB8B8E70050
     */
    public UIPartie(int nbVals, String[] nomFigure, int nbJoueurs) {
        this.nomFigure = new String[nomFigure.length];
 
        setSize(300+100*nbJoueurs,200+40*nomFigure.length);
  
        for (int i = 0; i < nomFigure.length; i ++)
          this.nomFigure[i] = nomFigure[i];

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        setLayout(gbl);
        
        setBackground(partieBG);
        setFont(new Font("Helvetica", Font.BOLD, 24));
        
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        m_UIHasard = new UIHasard(nbVals);
        
        
        gbl.setConstraints(m_UIHasard, gbc);
        add(m_UIHasard);
        disableHasard();
        
        bLancer = new Button("Lancer");
        bLancer.setBackground(bColor);
        bLancer.setSize(180,140);

        gbc.fill = GridBagConstraints.NONE;
        gbl.setConstraints(bLancer, gbc);
        add(bLancer);
        
        bLancer.addActionListener(this);

        bValider = new Button("Valider");
        bValider.setBackground(bColor);
        
        gbc.fill = GridBagConstraints.NONE;
        gbl.setConstraints(bValider, gbc);
        add(bValider);
        disableValider();
        
        bValider.addActionListener(this);


        gbc.gridwidth = nbJoueurs;

        m_UITableScore = new UITableScore[nbJoueurs];
        for (int i = 0; i < nbJoueurs; i++) {
            m_UITableScore[i] = new UITableScore(this, nomFigure);
            gbl.setConstraints(m_UITableScore[i], gbc);
            add(m_UITableScore[i]);
        }
    }
    
    public void setInterface(Partie pp) {
        laPartie = pp;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String nom = new String (e.toString());
        System.out.println(e.toString() + " " + nom);
        if (e.getActionCommand() == "Lancer") {
          laPartie.setHasard(m_UIHasard.getGarder());
        }
        else if (e.getActionCommand() == "Valider") {
          laPartie.validerScore();
        }
    }
    public void enableLancer() {
        bLancer.enable();
    }
    public void disableLancer() {
        bLancer.disable();
    }
    public void enableHasard() {
        m_UIHasard.enable();
    }
    
    public void disableHasard() {
        m_UIHasard.disable();
    }
    public void enableValider() {
        bValider.enable();
    }
    public void disableValider() {
        bValider.disable();
    }
    public boolean enableScore(int joueur) {
        return(m_UITableScore[joueur].enableScore());
    }
    public boolean disableScore(int joueur) {
        return(m_UITableScore[joueur].disableScore());
    }
    
    public int getSelection(int joueur) {
        return(m_UITableScore[joueur].getSelection());
    }
    public void setHasard(int[] vals) {
          // Option
          // m_UIHasard.reset();
        m_UIHasard.set(vals);
    }
    public void resetHasard() {
        m_UIHasard.reset();
    }
    public void setScore(int joueur, int indScore, int val) {
        m_UITableScore[joueur].setScore(indScore, val);
    }
    
    public int evaluerScore(int indScore) {
        return(laPartie.evaluerScore(indScore));
    }
    public void showTotal(int joueur, int total) {
        m_UITableScore[joueur].showTotal(total);
    }
}
