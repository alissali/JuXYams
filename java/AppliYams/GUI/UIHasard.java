// Source file: C:/WINDOWS/Bureau/Prototype/Java/AppliYams/GUI/UIHasard.java

package GUI;

import java.awt.Panel;
import java.awt.Button;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import java.awt.Insets;

public class UIHasard extends Panel {
    private int nbVals;
    private boolean[] garder;
    public UIValPanel m_UIValPanel[];
    
    UIHasard() {
        // Panel pCommandes = new Panel(new FlowLayout());
        
    }
    /**
       @roseuid 3BB8F2D50190
     */
    public UIHasard(int nbVals) {
        this.nbVals = nbVals;
        garder = new boolean[nbVals];
        // setLayout(new GridLayout(1, 5));

        GridBagLayout gbl = new GridBagLayout();
        setLayout(gbl);
        GridBagConstraints gbc = new GridBagConstraints();


        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(10, 10, 0, 0);
        m_UIValPanel = new UIValPanel[nbVals];
 
        gbc.fill= GridBagConstraints.NONE;

        gbc.gridwidth = nbVals;
        gbc.gridheight = 1;
        for (int i = 0; i < nbVals; i++) {
            m_UIValPanel[i] = new UIValPanel(i+1);
            gbl.setConstraints(m_UIValPanel[i], gbc);
            add(m_UIValPanel[i]);
        }
    }
    
    /**
       @roseuid 3BB8C38B03A2
     */
    public void set(int[] val) {
        for (int i = 0; i < nbVals; i++)
            m_UIValPanel[i].set(val[i]);
    }
    
    /**
       @roseuid 3BB8C38B03A3
     */
    public void reset() {
        for (int i = 0; i < nbVals; i++)
            m_UIValPanel[i].reset();
    }
    
    public void enable() {
        for (int i = 0; i < nbVals; i++)
            m_UIValPanel[i].enable();
    }
    public void disable() {
        for (int i = 0; i < nbVals; i++)
            m_UIValPanel[i].disable();
    }
    public boolean[] getGarder()
    {

        for (int i = 0; i < nbVals; i++)
            garder[i] = m_UIValPanel[i].getGarder();
            
        return(garder);
    }
}
