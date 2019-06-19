import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Manager {

    private String filePath;
    private String url;

    public Manager(String url) {
        this.url = url;
    }

    public void start(){
       try (BufferedReader bufferedReader = new BufferedReader
               (new InputStreamReader(System.in))) {
           filePathRequest(bufferedReader);
       } catch (IOException i){
            i.printStackTrace();
       }
            HtmlDownloader htmlDownloader = new HtmlDownloader(filePath,url);
            int result = htmlDownloader.download();
        System.out.println("The number of unique words " + result);
    }

    private void filePathRequest(BufferedReader bufferedReader) throws IOException{
        System.out.println("Enter path to save the file");
        filePath = bufferedReader.readLine();
        if ("".equals(filePath)){
            filePathRequest(bufferedReader);
        }
    }
}
