package Experiment1;

import java.io.IOException;

public class TestWebPageReader {
    public static void main(String[] args) throws IOException {
        WebPageReader webPageReader = new WebPageReader("http://www.somewhereinblog.net/blog/zicses/29153356");
        try {
            webPageReader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
