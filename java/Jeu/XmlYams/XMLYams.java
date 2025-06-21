package XMLYams;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import org.w3c.dom.*;

import java.io.*;

import java.lang.Integer;

public class XMLYams {
    
    static int[] bonus = new int[3];
    static String[] nomFigure = new String[20];
        
    static int nbClasse = 0;
    static String[] nomClasseFigure = new String[20];
    static String[] nomClasse = new String[10];
    static int[] scoreFigure = new int[20];
    static int nbFig = -1;
    
    /** All output will be use this encoding */
    static final String outputEncoding = "UTF-8";

    /** Output goes here */
    private PrintWriter out;

    /** Indent level */
    private int indent = 0;

    /** Indentation will be in multiples of basicIndent  */
    private final String basicIndent = "  ";
    // <Bricolage>
    public XMLYams() {
        OutputStreamWriter outWriter = null;
        try {
            outWriter =
            new OutputStreamWriter(System.out, outputEncoding);
        } catch(Exception e) {}

        this.out = new PrintWriter(outWriter, true);
    }
    XMLYams(PrintWriter out) {
        this.out = out;
    }
    // </Bricolage>

    /**
     * Indent to the current level in multiples of basicIndent
     */
    private void outputIndentation() {
        for (int i = 0; i < indent; i++) {
            out.print(basicIndent);
        }
    }

public String[] getNomClasse() {
        // <Bricolage>
        String[] result = new String[nbClasse];
        for (int i = 0; i < nbClasse; i++)
            result[i] = new String(nomClasse[i]);
        
        nomClasse = new String[nbClasse];
        for (int i = 0; i < nbClasse; i++)
            nomClasse[i] = new String(result[i]);

        // </Bricolage>;
    
    return(nomClasse);
}
public String[] getNomFigure() {
        // <Bricolage>
        String[] result = new String[nbFig];
        for (int i = 0; i < nbFig; i++)
            result[i] = new String(nomFigure[i]);
        
        nomFigure = new String[nbFig];
        for (int i = 0; i < nbFig; i++)
            nomFigure[i] = new String(result[i]);

        // </Bricolage>;
    return(nomFigure);
}
public String[] getNomClasseFigure() {
    return(nomClasseFigure);
}
public int[] getScoreFigure() {
    return(scoreFigure);
}

public int[] getBonus() {
    return(bonus);
}
    
 //   public static void main(String[] args) throws Exception {
public void parse(String[] args) throws Exception {
        String filename = null;
        boolean validation = false;

        boolean ignoreWhitespace = false;
        boolean ignoreComments = false;
        boolean putCDATAIntoText = false;
        boolean createEntityRefs = false;

        filename = args[0];

        if (filename == null) {
            System.out.println("Fichier invalide");
        }

        DocumentBuilderFactory dbf =
            DocumentBuilderFactory.newInstance();

        dbf.setValidating(validation);
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException pce) {
            System.err.println(pce);
            System.exit(1);
        }

        Document doc = null;
        try {
            doc = db.parse(new File(filename));
        } catch (SAXException se) {
            System.err.println(se.getMessage());
            System.exit(1);
        } catch (IOException ioe) {
            System.err.println(ioe);
            System.exit(1);
        }

        getDescJeu(doc);
        // <Bricolage>
        nbFig++;
        // </Bricolage>;
        
        
        System.out.println("nbFig : " + nbFig);
        for (int i = 0; i < 3; i++)
            System.out.println("bonus " + bonus[i]);

        for (int i = 0; i < nbFig; i++) {
            System.out.println(nomFigure[i] + " : " + scoreFigure[i] + ". " + nomClasseFigure[i]);
        }
    }
    
private void getDescJeu(Node n) {
        int type = n.getNodeType();
        switch (type) {
        case Node.ATTRIBUTE_NODE:
          // Comment convertir String en int ?
                out.print("Attribut non traite");
            // break;
            
        case Node.DOCUMENT_NODE:
            out.print("DOC:");
            break;
            
        case Node.DOCUMENT_TYPE_NODE:
            out.print("DOC_TYPE:");

            // Print entities if any
            NamedNodeMap nodeMap = ((DocumentType)n).getEntities();

            for (int i = 0; i < nodeMap.getLength(); i++) {
                Entity entity = (Entity)nodeMap.item(i);
            }
            break;
        case Node.ELEMENT_NODE:
            String nomNode = n.getNodeName();
            NamedNodeMap atts = n.getAttributes();
            
            if (nomNode.equals("Figure")) {
                for (int i = 0; i < atts.getLength(); i++) {
                    // System.out.println("Att : " + atts.item(i).getNodeName() + " " + atts.item(i).getNodeValue());
                    if (atts.item(i).getNodeName().equals("nom")) {
                        nomFigure[++nbFig] = new String(atts.item(i).getNodeValue());
                    }
                    else if (atts.item(i).getNodeName().equals("score")) {
                        // <jux:Note> String to int </jux:Note>
                        Integer score = new Integer(atts.item(i).getNodeValue());
                        scoreFigure[nbFig] = score.intValue();
                    }
                    else if (atts.item(i).getNodeName().equals("classe")) {
                        int j;
                        
                        String nomCls = new String(atts.item(i).getNodeValue());
                        nomClasseFigure[nbFig] = new String (nomCls);
                        for (j = 0; j < nbClasse; j++) {
                            if (nomCls.equals(nomClasse[j])) break;
                        }
                        if (j == nbClasse)
                            nomClasse[nbClasse++] = new String (nomCls);        
                    }
                }
            }
            else if (nomNode.equals("Bonus")) {
                int nb = 0;
                
                atts = n.getAttributes();
                
                for (int i = 0; i < atts.getLength(); i++) {
                        Integer val = new Integer(atts.item(i).getNodeValue());
                        bonus[i] = val.intValue();
                }
                for (int i = 0; i < bonus[0]; i++) {
                    nomFigure[++nbFig] =  String.valueOf(i+1);
                    nomClasseFigure[nbFig] =  new String("Somme");
                }
            }
            break;            
        }
        for (Node child = n.getFirstChild(); child != null;
             child = child.getNextSibling()) {
            getDescJeu(child);
             }
        }
        
}
