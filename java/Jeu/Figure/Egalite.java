// Source file: C:/WINDOWS/Bureau/Prototype/Java/Jeu/Figure/Egalite.java

package Figure;

public class Egalite extends Figure {
    
    Egalite() {
    }
    /**
       @roseuid 3BAE764C02BC
     */
    public Egalite(int typeFigure, int score) {
        super(typeFigure, score);
    }
    
    /**
       @roseuid 3BB3AB40028A
     */
    public IFigure get(String figure) {
        return(this);
    }
    
    /**
       @roseuid 3BB4789100AA
     */
    public int getScore() {
        if(s_IHasardFigure.nbEgaux(typeFigure) == typeFigure)
            return(super.getScore());
        return(0);
    }
}
