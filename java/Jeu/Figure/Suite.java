// Source file: C:/WINDOWS/Bureau/Prototype/Java/Jeu/Figure/Suite.java

package Figure;

public class Suite extends Figure {
    
    Suite() {
    }
    /**
       @roseuid 3BB02FBE0200
     */
    public Suite(int typeFigure, int score) {
        super(typeFigure, score);
    }
    
    /**
       @roseuid 3BB3AB410028
     */
    public IFigure get(String figure) {
        return(this);
        
    }
    
    /**
       @roseuid 3BB478AA03D4
     */
    public int getScore() {
        System.out.println("Suite : " + typeFigure);
        if (s_IHasardFigure.nbEgaux(0) == 1)
            if ( ((typeFigure == 7) && (s_IHasardFigure.max() == 5))
              || ((typeFigure == 8) && (s_IHasardFigure.min() == 2)))
                return(super.getScore());
                
        return(0);
    }
}
