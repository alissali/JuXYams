// Source file: C:/WINDOWS/Bureau/Prototype/Java/Jeu/Figure/Somme.java

package Figure;

public class Somme extends Figure {
    
    Somme() {
    }
    /**
       @roseuid 3BAE7586032A
     */
    public Somme(int typeFigure, int score) {
        super(typeFigure, score);
    }
    
    /**
       @roseuid 3BB3AB40017C
     */
    public IFigure get(String figure) {
        return(this);
    }
    
    /**
       @roseuid 3BB478E10168
     */
    public int getScore() {
        return(s_IHasardFigure.nbVals(typeFigure)*typeFigure);
    }
}
