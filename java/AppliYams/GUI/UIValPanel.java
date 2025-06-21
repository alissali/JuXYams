// Source file: C:/WINDOWS/Bureau/Prototype/Java/AppliYams/GUI/UIValPanel.java

package GUI;

import java.awt.Panel;
import java.awt.event.ItemListener;
import java.awt.Checkbox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ItemEvent;

import java.awt.Font;

public class UIValPanel extends Panel implements ItemListener {
    private boolean garde = false;
    public Checkbox m_Checkbox;
    public UIDes m_UIDes;
    //<Modif type = "parametrage">
    private Font mFont =  new Font("Helvetica", Font.ITALIC, 12);
    //</Modif>

    UIValPanel() {
    }
    /**
       @roseuid 3BC5F8DB01FE
     */
    public UIValPanel(int val) {
        GridBagLayout gbl = new GridBagLayout();
        setLayout(gbl);
        setFont (mFont);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        
        m_UIDes = new UIDes(val);
        gbl.setConstraints(m_UIDes, gbc);
        add(m_UIDes);
        
        m_Checkbox= new Checkbox("Garder");
        m_Checkbox.addItemListener(this);
        gbc.gridwidth = 1;
        gbl.setConstraints(m_Checkbox, gbc);
        add(m_Checkbox);
    }
    
    /**
       @roseuid 3BB8DE8902D0
     */
    public void set(int val) {
        m_UIDes.set(val);
    }
    
    /**
       @roseuid 3BB8DE91001E
     */
    public void reset() {
        m_Checkbox.setState(false);
        garde = false;
    }
    public void enable() {
        m_Checkbox.setEnabled(true);
    }
    public void disable() {
        m_Checkbox.setEnabled(false);
    }
    
    public boolean getGarder() {
        return(garde);
    }
    
    /**
     * Invoked when an item's state has been changed.
     * @roseuid 3BC607AB037A
     */
    public void itemStateChanged(ItemEvent e) {
          System.out.println("Status Changed" + " " + m_Checkbox.getState());
          garde = !garde;
    }
}
