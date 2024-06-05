import java.util.ArrayList;
import java.util.List;

public class Undo {

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

    public void remove(String id) {
        undo.add("option 2 -> remove a String by ID");


        int idToRemove;
        try {
            idToRemove = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format: " + id);
            undo.add("REMOVE invalid ID format: " + id);
            return;
        }
        boolean exist = wordsGens.removeIf(wordsGen -> wordsGen != null && wordsGen.getId() == idToRemove);

        if (exist) {
            System.out.println("String successfully removed!");
            undo.add(REMOVE + idToRemove);
        } else {
            System.out.println("The String with id: " + id + " does not exist");
            undo.add(REMOVE + " does not exist buddy");
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
            wordsGens.forEach(System.out::println);
        }
    }

    public void undoList() {
        undo.add("option 4 -> list UNDO History");

        undo.forEach(System.out::println);
    }

    public static List<String> getUndo() {
        return undo;
    }
}
