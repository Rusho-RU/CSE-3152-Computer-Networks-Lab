package Experiment2;

import java.net.UnknownHostException;

public class TestGetIPAddress {
    public static void main(String[] args) throws UnknownHostException {
        GetIPAddress getIPAddress = new GetIPAddress("https://www.youtube.com/");
        try {
            System.out.println(getIPAddress.getIP());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
