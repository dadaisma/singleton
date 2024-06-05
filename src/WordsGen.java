//
import java.util.Date;
import java.util.UUID;
public class WordsGen {
    private static int counter = 1; // Static counter for ID generation

    private final int id;
    private final String word;
    private final Date date;

    public WordsGen() {
        id = counter++; // Increment counter and assign to ID
        word = generateRandomString();
        date = new Date();
    }

    private String generateRandomString() {
        return UUID.randomUUID().toString().substring(0, 5);
    }

    public String getWord() {
        return word;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return "Random String generated-> "+ " id: " + id + " word: " + word + " on: "+ date;
    }
}
