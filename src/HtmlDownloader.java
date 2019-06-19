import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HtmlDownloader {

    private String filePath;
    private String url;
    private String fileName;

    public HtmlDownloader(String filePath, String url) {
        this.filePath = filePath;
        this.url = url;
    }

    public int download() {
        try {
            URL u = new URL(url);
            fileName = filePath+"\\"+u.getHost()+".html";
            HttpURLConnection connect = (HttpURLConnection) u.openConnection();
            connect.setReadTimeout(0);
            int response = connect.getResponseCode();
            if (response == HttpURLConnection.HTTP_OK) {
                try (InputStream inputStream = connect.getInputStream()) {
                    try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
                        byte [] buffer = new byte[1024];
                        int bytes;
                        while ((bytes = inputStream.read(buffer)) >= 0) {
                            byteArrayOutputStream.write(buffer, 0, bytes);
                        }
                        saveFile(byteArrayOutputStream);
                       return new WordCounter(fileName).parseHtml();
                    }
                }
            } else {
                System.out.println("Error connect to site");
                System.exit(1);
            }
    } catch(IOException i){
            i.printStackTrace();
        System.err.println("Error downloading the file " + fileName);
    }
    return 0;
}

    private void saveFile (ByteArrayOutputStream b){
        File file = new File(fileName);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            b.writeTo(fileOutputStream);
            System.out.println("File "+fileName+" downloaded");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error writing the file " + fileName);
        }
    }
}

