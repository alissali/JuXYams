// Source file: C:/WINDOWS/Bureau/Prototype/Java/AppliYams/GUI/UIDes.java

package GUI;

import java.awt.Component;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.Graphics2D;
import java.awt.Graphics;


public class UIDes extends Component {
    private int val = 5;
    private boolean garde = false;
    private int taille = 80;
    private int taillePoint = taille/4 - 1;
    private int arcw = taille/5;
    private int arch = taille/5;
    private int marge = taille/8;
    
    // <Modif type = "evolution">

    /*
    // vert
    private Color couleurPoint = new Color(255, 255, 255);
    private Color couleurDes = new Color(0, 180, 80);
    private Color couleurBord = new Color(80, 180, 80);

    // magenta
    private Color couleurPoint = new Color(180, 180, 180);
    private Color couleurDes = new Color(0, 0, 0);
    private Color couleurBord = new Color(80, 180, 255);

    // bleu
    private Color couleurPoint = new Color(0, 120, 180);
    private Color couleurDes = new Color(0, 20, 60);
    private Color couleurBord = new Color(0, 40, 120);
    */
    private Color couleurPoint = new Color(40, 40, 80);
    private Color couleurDes = new Color(240, 220, 0);
    private Color couleurBord = new Color(15, 20, 50);
    //    ajouter un menu couleur
    //      <Generalisation/>
    // </Modif>   
    UIDes() {
    }
    /**
       @roseuid 3BB8E30E0154
     */
    public UIDes(int val) {
        this.val = val;
    }
    
    /**
       @roseuid 3BB8E30E0156
     */
    public void set(int val) {
        this.val = val;
        repaint();
    }
    
    /**
     * Gets the preferred size of this component.
     * @return A dimension object indicating this component's preferred size.
     * @see #getMinimumSize
     * @see java.awt.LayoutManager
     * @roseuid 3BB8E30E0158
     */
    public Dimension getPreferredSize() {
	  return new Dimension(taille+40, taille+40);
    }
    
    /**
     * Gets the mininimum size of this component.
     * @return A dimension object indicating this component's minimum size.
     * @see #getPreferredSize
     * @see java.awtLayoutManager
     * @roseuid 3BB8E30E0190
     */
    public Dimension getMinimumSize() {
      return new Dimension(taille+40, taille+40);
    }
    
    /**
     * Paints this component.  This method is called when the contents
     * of the component should be painted in response to the component
     * first being shown or damage needing repair.  The clip rectangle
     * in the Graphics parameter will be set to the area which needs
     * to be painted.
     * @param <code>g</code> The graphics context to use for painting.
     * @see       java.awt.Component#update
     * @since     JDK1.0
     * @roseuid 3BB8E30E0191
     */
    public void paint(Graphics g) {
        float x = 0;
        float y = 0;
        Graphics2D screen2D = (Graphics2D) g;
        screen2D.setColor(couleurDes);
        RoundRectangle2D.Float d1 = new RoundRectangle2D.Float(x, y,
           taille, taille, arcw, arch);
        screen2D.fill(d1);
        screen2D.setColor(couleurBord);
        RoundRectangle2D.Float o1 = new RoundRectangle2D.Float(x, y,
            taille, taille, arcw, arch);
        screen2D.draw(o1);
        screen2D.setColor(couleurPoint);
        int hg = (int) x + marge;
        int bd = (int) x + taille - marge - taillePoint;
        int milieu = (hg+bd)/2;
        
        if (val > 1) {
            Ellipse2D.Float s1 = new Ellipse2D.Float(bd, hg,
                taillePoint, taillePoint);
            screen2D.fill(s1);
            Ellipse2D.Float s2 = new Ellipse2D.Float(hg, bd,
                taillePoint, taillePoint);
            screen2D.fill(s2);
        }
        if (val > 3) {
            Ellipse2D.Float s1 = new Ellipse2D.Float(hg, hg,
                taillePoint, taillePoint);
            screen2D.fill(s1);
            Ellipse2D.Float s2 = new Ellipse2D.Float(bd, bd,
                taillePoint, taillePoint);
            screen2D.fill(s2);
        }
        if (val == 6) {
            Ellipse2D.Float s1 = new Ellipse2D.Float(hg, milieu,
                taillePoint, taillePoint);
            screen2D.fill(s1);
            Ellipse2D.Float s2 = new Ellipse2D.Float(bd, milieu,
                taillePoint, taillePoint);
            screen2D.fill(s2);
        }
        if (val % 2 == 1) {
            Ellipse2D.Float s1 = new Ellipse2D.Float(milieu, milieu,
                taillePoint, taillePoint);
            screen2D.fill(s1);
        }
        
    }
}
