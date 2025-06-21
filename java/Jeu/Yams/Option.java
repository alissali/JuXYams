// Source file: C:/WINDOWS/Bureau/Prototype/Java/Jeu/Figure/Option.java

package Figure;

public class Option extends Figure {
    
    Option() {
    }
    /**
       @roseuid 3BAE76540154
     */
    public Option(int typeFigure, int score) {
        super(typeFigure, score);
    }
    
    /**
       @roseuid 3BB3AB400366
     */
    public IFigure get(String figure) {
        return(this);
    }
    
    /**
       @roseuid 3BB4789B0258
     */
    public int getScore() {
        return(typeFigure*s_IHasardFigure.somme());
    }
}
