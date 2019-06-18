import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Manager {

    private String filePath;
    private String url;
    private BufferedReader bufferedReader;

   public void start(){
       bufferedReader = new BufferedReader
               (new InputStreamReader(System.in));
       try {
           filePathRequest();

       } catch (IOException i){
            i.printStackTrace();
       }

       try {
           urlRequest();
       } catch (IOException i1){
            i1.printStackTrace();
       } finally {
           try {
               bufferedReader.close();
           } catch (IOException i2){
               i2.printStackTrace();
           }
       }
            HtmlDownloader htmlDownloader = new HtmlDownloader(filePath,url);
            htmlDownloader.download();
    }

    private void filePathRequest() throws IOException{
        System.out.println("Enter filepath");
        filePath = bufferedReader.readLine();
        if ("".equals(filePath)){
            filePathRequest();
        }
    }

    private void urlRequest() throws IOException {
        System.out.println("Enter URL");
        url = bufferedReader.readLine();
        if ("".equals(url)){
            urlRequest();
        }
    }
}
