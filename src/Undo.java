import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Undo {
//t
    private static Undo instance;
    private static List<WordsGen> wordsGens = new ArrayList<>();
    private static List<String> undo = new ArrayList<>(List.of("***UNDO ITEMS***"));
    private static final String ADD = "Great, you have generated a Random String: ";
    private static final String REMOVE = "Boom, you have deleted a Random String generated: ";
    private static final String LIST = "Here are your generated Random Strings: ";

    private Undo() {}

    public static Undo getInstance() {
        if (instance == null) {
            instance = new Undo();
        }
        return instance;
    }

    public void remove(String word) {
        undo.add("option 2 -> remove a String");
        boolean exist = false;
        WordsGen wordsGen;
        Iterator<WordsGen> iterator = wordsGens.iterator();

        while (iterator.hasNext()) {
            wordsGen = iterator.next();
            if (wordsGen != null && wordsGen.getWord().equals(word)) {
                iterator.remove();
                System.out.println("String successfully removed!");
                exist = true;
                undo.add(REMOVE + wordsGen.getWord());
            }
        }

        if (!exist) {
            System.out.println("The String does not exist");
            undo.add(REMOVE + " does not Exist buddy");
        }
    }

    public void add(WordsGen w) {
        undo.add("option 1 -> add a String");
        wordsGens.add(w);
        System.out.println("String added successfully!"+w);
        undo.add(ADD + w.getWord());
    }

    public void list() {
        undo.add("option 3 -> list Strings");

        if (wordsGens.isEmpty()) {
            System.out.println("There are currently no generated Strings in the list.");
        } else {
            wordsGens.forEach(wordsGen -> System.out.println(wordsGen));
        }
    }

    public void undoList() {
        undo.add("option 4 -> list UNDO History");
        // Consider enhancing output format for better readability (e.g., timestamps)
        undo.forEach(undo -> System.out.println(undo));
    }

    public static List<String> getUndo() {
        return undo;
    }
}
