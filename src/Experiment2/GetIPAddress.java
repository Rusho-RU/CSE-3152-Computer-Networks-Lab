package Experiment2;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class GetIPAddress {
    private String url;

    GetIPAddress(String _url){
        url = _url;
    }

    GetIPAddress(){
        url = "http://www.google.com/";
    }

    public String getIP() throws UnknownHostException {
        try {
            InetAddress host = InetAddress.getByName(new URL(url).getHost());
            return host.getHostAddress();
        } catch (UnknownHostException | MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
