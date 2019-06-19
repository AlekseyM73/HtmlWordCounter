import org.jsoup.Jsoup;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounter {

    private String fileName;

    public WordCounter(String fileName) {
        this.fileName = fileName;
    }

    public int parseHtml (){
        try {
            File file = new File(fileName);
            String textOnly = Jsoup.parse(file,"UTF-8").text();
            Set<String> set = Stream.of
                    (textOnly.split("[^A-Za-zА-Яа-я]+"))
                    .map(String::toLowerCase).collect(Collectors.toSet());
            return set.size();
        } catch (IOException i){
            i.printStackTrace();
        }
        return 0;
    }
}
