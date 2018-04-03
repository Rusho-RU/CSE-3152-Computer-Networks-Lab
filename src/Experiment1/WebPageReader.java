package Experiment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WebPageReader {
    private String webpage;

    WebPageReader(String _url){
        webpage = _url;
    }

    WebPageReader(){
        webpage = "http://www.codeforces.com/";
    }

    public void read() throws IOException {
        URL url = new URL(webpage);
        URLConnection urlConnection = url.openConnection();
        BufferedReader page = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        String line;

        while((line = page.readLine()) != null){
            System.out.println(line);
        }
    }
}
