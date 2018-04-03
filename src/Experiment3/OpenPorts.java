package Experiment3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class OpenPorts {
    private String proxy;

    OpenPorts(String _proxy){
        proxy = _proxy;
    }

    OpenPorts() throws UnknownHostException {
        InetAddress hostAddress = InetAddress.getLocalHost();
        proxy = hostAddress.toString();
    }

    public void printOpenPorts() throws IOException {
        for(int i=0; i<65366; i++) {
            try {
                Socket socket = new Socket(proxy, i);
                System.out.println("Port not in use: " + i );
                socket.close();
            }catch(Exception e){
                //System.out.println("Port in use: " + i );
            }
        }
    }
}
