package LabTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    private ServerSocket serverSocket;
    private int port;

    Server(int _port){
        try{
            port = _port;
            serverSocket = new ServerSocket(port);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(){
        while(true){
            try{
                System.out.println("Server waiting for connection in port : " + port + ".");
                Socket socket = serverSocket.accept();
                System.out.println("User Connected");
            }catch (IOException io){
                io.printStackTrace();
            }
        }
    }
}
