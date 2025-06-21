// Source file: C:/WINDOWS/Bureau/Prototype/Java/AppliYams/GUI/UIScore.java

package GUI;

import java.awt.Panel;
import java.awt.TextField;
import java.awt.Font;
import java.awt.Checkbox;
import java.awt.GridLayout;

import java.awt.Color;

public class UIScore extends Panel {
    private int score = -1;
    private String nomFigure;
    public TextField m_TextField;
    public Checkbox m_Checkbox;
    public UITableScore m_parent;
    
/*
    // vert 
    private Color tfColor = new Color(40, 180, 80);
    private Color cbColor = new Color(60, 180, 80);

    // magenta
    private Color tfColor = new Color(180, 40, 60);
    private Color cbColor = new Color(180, 40, 80);

    // bleu
    private Color tfColor = new Color(40, 80, 180);
    private Color cbColor = new Color(60, 80, 180);
    // vert
    private Color tfColor = new Color(10, 180, 90);
    private Color cbColor = new Color(20, 220, 120);
    */
 
    private Color tfColor = new Color(10, 90, 180);
    private Color cbColor = new Color(20, 120, 220);

    UIScore() {
    }
    /**
       @roseuid 3BB8B9A1010E
     */
    public UIScore(UITableScore m_parent, String nomFigure) {
            this.m_parent = m_parent;
            this.nomFigure = nomFigure;
              
            setFont(new Font("Helvetica", Font.BOLD, 14));
            setLayout(new GridLayout(1,2));
            m_TextField = new TextField("---");
            m_TextField.setBackground(tfColor);
            m_TextField.setEditable(false);
            add(m_TextField);
            
            m_Checkbox = new Checkbox(nomFigure);
            m_Checkbox.setBackground(cbColor);
            m_Checkbox.addItemListener(m_parent);
            add(m_Checkbox);
    }
    
    public void set(int score) {
        this.score = score;
        show(score); 
    }    

    public int get() {
        return(score);
    }
    
    public void show(int score) {
        if (score == 0)
            m_TextField.setForeground(Color.red);
        m_TextField.setText(String.valueOf(score));
        m_Checkbox.setEnabled(false);
    }    
    public void reset() {
        if (score == -1) {
            m_TextField.setForeground(Color.black);
            m_TextField.setText("---");
        }
        m_Checkbox.setState(false);
        m_Checkbox.setEnabled(true);
    }    
    public boolean enableScore() {
        if (score != -1)
            return false;
            
        m_Checkbox.setEnabled(true);
        return(true);
    }    
    public boolean disableScore() {
        m_Checkbox.setEnabled(false);
        return (score == -1);
    }    
}
