package Experiment10;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception{
        DatagramSocket cs = new DatagramSocket();
        byte[] dataSend = new byte[1024];
        byte[] dataReceive = new byte[1024];
        boolean firstClientMessage = false;
        boolean firstServerMessage = false;
        String sentence = "";

        while(true){
            InetAddress ipAddress = InetAddress.getByName("localhost");

            if(firstClientMessage){
                System.out.println("Client: ");
                Scanner scan = new Scanner(System.in);
                sentence = scan.nextLine();
            }

            else{
                sentence = "One client connected";
                firstClientMessage = true;
            }

            dataSend = sentence.getBytes();
            DatagramPacket packetData = new DatagramPacket(dataSend, dataSend.length, ipAddress, 20000);
            cs.send(packetData);

            if(sentence.equals("QUIT")){
                System.out.println("Connection terminated");
                break;
            }

            DatagramPacket receivePacket = new DatagramPacket(dataReceive, dataReceive.length);
            cs.receive(receivePacket);
            String modifiedSentence = new String(receivePacket.getData(),0,receivePacket.getLength());
            System.out.println("Server Reply:" + modifiedSentence);
        }

        cs.close();
    }
}
