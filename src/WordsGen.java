//
import java.util.Date;
import java.util.UUID;
public class WordsGen {
    private final String Word;
    private final Date Date;

    public WordsGen(){

        Word = generateRandomString();
        Date = new Date();
    }
    private String generateRandomString(){
        return UUID.randomUUID().toString().substring(0,5);
    }
    public String getWord(){
        return Word;
    }

    @Override
    public String toString(){
        return "Random String generated-> "+ Word+ " on: "+Date;
    }
}
