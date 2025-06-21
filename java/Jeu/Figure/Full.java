// Source file: C:/WINDOWS/Bureau/Prototype/Java/Jeu/Figure/Full.java

package Figure;

public class Full extends Figure {
    
    Full() {
    }
    /**
       @roseuid 3BB3C226019A
     */
    public Full(int typeFigure, int score) {
        super(typeFigure, score);
    }
    
    /**
       @roseuid 3BB3AB410172
     */
    public IFigure get(String figure) {
        return(this);
        
    }
    
    /**
       @roseuid 3BB478B703AC
     */
    public int getScore() {
        if(s_IHasardFigure.full()) {
            return(super.getScore());
        }
            
        return(0);
    }
}
