package Experiment1;

import java.io.IOException;

public class TestWebPageReader {
    public static void main(String[] args) throws IOException {
        WebPageReader webPageReader = new WebPageReader("https://www.youtube.com/");
        try {
            webPageReader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
