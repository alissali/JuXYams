// Source file: C:/WINDOWS/Bureau/Prototype/Java/AppliYams/GUI/UITableScore.java

package GUI;

import java.awt.Panel;
import java.awt.GridLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import java.awt.Font;
import java.awt.TextField;
import java.awt.Color;

public class UITableScore extends Panel implements ItemListener {
    private int nbScores;
    private String[] nomFigure;
    private int nbFigures;
    public UIScore m_UIScore[];
    private int selectionCourante = -1;
    private UIPartie parent;
    
    private TextField totalTF;

    // bleu : magenta a faire
    /*
    private Color couleurTotalBG = new Color(0, 80, 180);
    private Color couleurTotalFG = new Color(80, 180, 255);
    */
    /* vert
    private Color couleurTotalBG = new Color(20, 90, 60);
    private Color couleurTotalFG = new Color(40, 200, 140);
    */
    private Color couleurTotalBG = new Color(20, 60, 90);
    private Color couleurTotalFG = new Color(40, 140, 200);
    UITableScore() {
    }
    /**
       @roseuid 3BB4F308035C
     */
    public UITableScore(UIPartie pp, String[] nomFigure) {
        parent = pp;
        this.nbFigures = nomFigure.length;
        this.nomFigure = new String[nbFigures];
        
        setLayout(new GridLayout(nbFigures + 1, 1));

        m_UIScore = new UIScore[nbFigures];
        for (int i = 0; i < nbFigures; i ++) {
          this.nomFigure[i] = nomFigure[i];
          m_UIScore[i] = new UIScore(this, nomFigure[i]);
          add(m_UIScore[i]);
        }
        setFont(new Font("Helvetica", Font.BOLD, 18));
        totalTF = new TextField("0");
        totalTF.setEditable(false);
        totalTF.setBackground(couleurTotalBG);
        totalTF.setForeground(couleurTotalFG);
        add(totalTF);
        
        disableScore();
    }
    /**
       @roseuid 3BC60C0100AA
     */
    public void itemStateChanged(ItemEvent e) {
          int i;
          
          System.out.println("Score Status Changed");
          System.out.println("Event :" + e.getItem() + " " + e);
          for(i = 0; !e.getItem().equals(nomFigure[i]); i++);
          System.out.println("i :" + i);
          if (selectionCourante != -1) 
            m_UIScore[selectionCourante].reset();
          selectionCourante = i;

          m_UIScore[selectionCourante].show(parent.evaluerScore(selectionCourante));
    }
    public int getSelection() {
        int val = selectionCourante;
        
        return(val);
    }
    public void setScore(int indScore, int score) {
        m_UIScore[indScore].set(score);
    }

    public boolean enableScore() {
        boolean tableauNonPlein = false;

        for (int i = 0; i < nbFigures; i ++)
          if (m_UIScore[i].enableScore() && !tableauNonPlein)
            tableauNonPlein = true; 
            
        return(tableauNonPlein);
    }
    public boolean disableScore() {
        boolean tableauNonPlein = false;
        
        selectionCourante = -1;
        
        for (int i = 0; i < nbFigures; i ++)
          if (m_UIScore[i].disableScore() && !tableauNonPlein)
            tableauNonPlein = true; 
            
        return(tableauNonPlein);
    }
    
    public void showTotal(int total) {
        
        totalTF.setText(String.valueOf(total));
        
    // <Modif> Option avec Thraeds
    /*
        int score;
        
        for (int i = 0; i < nbFigures; i ++) {
            score = m_UIScore[i].get();
            m_UIScore[i].set(total);
            try {
                wait(500);
            } catch (Exception e) {System.out.println(e.toString());}
            // m_UIScore[i].set(score);           
        }
    */
    //</Modif>
    }
}

