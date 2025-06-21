// Source file: C:/WINDOWS/Bureau/Prototype/Java/Jeu/Figure/Figure.java

package Figure;

import Hasard.IHasardFigure;


public abstract class Figure implements IFigure {
    protected int typeFigure;
    protected int score;
    public static IHasardFigure s_IHasardFigure;
    
    Figure() {
    }
    /**
       @roseuid 3BAE76220276
     */
    public Figure(int typeFigure, int score) {
        // System.out.println("Figure : " + typeFigure + " " + score);
        this.typeFigure = typeFigure;
        this.score = score;
    }
    
    /**
       @roseuid 3BB3D6E803B6
     */
    public int getScore() {
        // Somme et Option n'utilisent pas cette valeur
        return(score);
    }
}
