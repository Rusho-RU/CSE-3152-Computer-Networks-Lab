package Experiment3;

import java.io.IOException;

public class TestOpenPorts {
    public static void main(String[] args) throws IOException {
        OpenPorts openPorts = new OpenPorts("127.0.0.1");
        try {
            openPorts.printOpenPorts();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
