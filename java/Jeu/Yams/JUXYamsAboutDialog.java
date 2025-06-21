/*
	A basic extension of the java.awt.Dialog class
 */
package InterfaceUtilisateur;

import java.awt.*;

public class JUXYamsAboutDialog extends Dialog {

private static String apropos
          =  new String("      YAMS\n      JUX\n Copyright : M. Alissali 2001\n Mail : alissali.mamoun@wanadoo.fr");
	TextArea yAboutTextArea = new TextArea(apropos, 4, 30, TextArea.SCROLLBARS_NONE);
	Button okButton = new java.awt.Button();
	public JUXYamsAboutDialog(Frame parent, boolean modal)
	{
		super(parent, modal);
        
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
		setLayout(gbl);
		setSize(300,200);
		setVisible(false);

		 gbc.weightx = 1.0;
		 gbc.weighty = 1.0;
        gbl.setConstraints(yAboutTextArea, gbc);
		yAboutTextArea.setEditable(false);
		yAboutTextArea.setFont(new Font("Helvetica", Font.PLAIN, 14));
		add(yAboutTextArea);
		 // label1.setBounds(40,35,166,21);
        gbl.setConstraints(okButton, gbc);
		okButton.setLabel("OK");
		add(okButton);
		// okButton.setBounds(95,85,66,27);
		setTitle("JUXYams");
		//}}
        
		//{{REGISTER_LISTENERS
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		okButton.addActionListener(lSymAction);
		//}}

	}
    
	public JUXYamsAboutDialog(Frame parent, String title, boolean modal)
	{
		this(parent, modal);
		setTitle(title);
	}

	public void addNotify()
	{
		// Record the size of the window prior to calling parents addNotify.
                Dimension d = getSize();

		super.addNotify();

		// Only do this once.
		if (fComponentsAdjusted)
			return;

		// Adjust components according to the insets
		Insets insets = getInsets();
		setSize(insets.left + insets.right + d.width, insets.top + insets.bottom + d.height);
		Component components[] = getComponents();
		for (int i = 0; i < components.length; i++)
		{
			Point p = components[i].getLocation();
			p.translate(insets.left, insets.top);
			components[i].setLocation(p);
		}

		// Used for addNotify check.
		fComponentsAdjusted = true;
	}

	public void setVisible(boolean b)
	{
	    if (b)
	    {
    		Rectangle bounds = getParent().getBounds();
    		Rectangle abounds = getBounds();

    		setLocation(100 + bounds.x + (bounds.width - abounds.width)/ 2,
    			 100+ bounds.y + (bounds.height - abounds.height)/2);
	    }

		super.setVisible(b);
	}

    
    // Used for addNotify check.
	boolean fComponentsAdjusted = false;

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == okButton)
				okButton_ActionPerformed(event);
		}
	}

	void okButton_ActionPerformed(java.awt.event.ActionEvent event)
	{
		// to do: code goes here.
			 
		okButton_ActionPerformed_Interaction1(event);
	}


	void okButton_ActionPerformed_Interaction1(java.awt.event.ActionEvent event)
	{
		try {
			this.dispose();
		} catch (Exception e) {
		}
	}


	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == JUXYamsAboutDialog.this)
				AboutDialog_WindowClosing(event);
		}
	}

	void AboutDialog_WindowClosing(java.awt.event.WindowEvent event)
	{
		// to do: code goes here.
			 
		AboutDialog_WindowClosing_Interaction1(event);
	}


	void AboutDialog_WindowClosing_Interaction1(java.awt.event.WindowEvent event)
	{
		try {
			this.dispose();
		} catch (Exception e) {
		}
	}

}
