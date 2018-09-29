package Experiment10;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) throws Exception{
        DatagramSocket ss = new DatagramSocket(20000);
        byte[] dataSend = new byte[1024];
        byte[] dataReceive = new byte[1024];
        boolean firstClientMessage = false;
        boolean firstServerMessage = false;

        while(true){
            DatagramPacket packetReceive = new DatagramPacket(dataReceive, dataReceive.length);
            ss.receive(packetReceive);
            String sentence = new String(packetReceive.getData(), 0, packetReceive.getLength());

            if(sentence.equals("QUIT")){
                System.out.println("Client is disconnected");
                break;
            }

            if(firstClientMessage)
                System.out.println("Client says: ");

            else
                firstClientMessage = true;

            System.out.println(sentence);

            if(!firstServerMessage){
                sentence = "You are connected to the Echo server";
                firstServerMessage = true;
            }

            InetAddress ipAddress = packetReceive.getAddress();
            int port = packetReceive.getPort();
            dataSend = sentence.getBytes();
            DatagramPacket packetSend = new DatagramPacket(dataSend, dataSend.length, ipAddress, port);
            ss.send(packetSend);
        }

        ss.close();
    }
}
