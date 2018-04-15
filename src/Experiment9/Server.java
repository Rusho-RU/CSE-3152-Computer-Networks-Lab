package Experiment9;

import java.io.DataInputStream;
import java.io.FileOutputStream;
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
                saveFile(socket);
            }catch (IOException io){
                io.printStackTrace();
            }
        }
    }

    private void saveFile(Socket socket) throws IOException {
        DataInputStream input = new DataInputStream(socket.getInputStream());
        FileOutputStream output  = new FileOutputStream("Katakuri1.png");
        byte[] buffer = new byte[4096];

        int fileSize = 15123;
        int read = 0;
        int remaining = fileSize;

        while((read = input.read(buffer, 0, Math.min(remaining, buffer.length))) > 0){
            remaining -= read;
            output.write(buffer, 0, read);
        }

        input.close();
        output.close();
    }
}
