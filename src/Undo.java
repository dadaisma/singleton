import java.util.ArrayList;
import java.util.List;

public class Undo {

    private static Undo instance;
    private static List<WordsGen> wordsGens = new ArrayList<WordsGen>();
    private static List<String> undo = new ArrayList<String>(List.of("***UNDO ITEMS***"));
    private static final String ADD = "Great, you have generated a Random String: ";
    private static final String REMOVE = "Boom, you have deleted a Random String generated: ";
    private static final String LIST ="Here is your geneated Random Strings: ";

    private Undo(){

    }


}
