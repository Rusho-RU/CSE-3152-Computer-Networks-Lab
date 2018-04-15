package Experiment9;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private Socket socket;

    Client(String host, int port, String file){
        try{
            socket = new Socket(host, port);
            sendFile(file);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendFile(String file) throws IOException {
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        FileInputStream input = new FileInputStream(file);
        byte[] buffer = new byte[4096];

        while(input.read(buffer) > 0){
            output.write(buffer);
        }

        input.close();
        output.close();
    }
}
