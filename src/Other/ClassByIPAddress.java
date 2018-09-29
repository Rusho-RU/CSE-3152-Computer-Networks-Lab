package Other;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ClassByIPAddress {
    private String ipAddress;

    ClassByIPAddress() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        ipAddress  = inetAddress.toString();
    }

    ClassByIPAddress(String _ipAddress){
        ipAddress = _ipAddress;
    }

    public String getClassName(){
        int[] data = new int[4];
        int last = 0, size=0, dotCount=0;

        for(int i=0; i<ipAddress.length(); i++){
            if(ipAddress.charAt(i) == '.'){
                if(last == i)
                    return "Invalid IP Address";

                data[size++] = Integer.parseInt(ipAddress.substring(last,i));
                last = i+1;
                dotCount++;
            }
        }

        if(dotCount < 3 || last==ipAddress.length())
            return "Invalid IP Address";

        data[size++] = Integer.parseInt(ipAddress.substring(last,ipAddress.length()));

        if(size==4){
            for(int i=0; i<4; i++){
                int max = (1 << 8) - 1;
                if(data[i] > max)
                    return "Invalid IP Address";
            }
        }

        int value = data[0];

        if ((value & 1<<7) == 0)
            return "Class A";

        if((value & 1<<6) == 0)
            return "Class B";

        if((value & 1<<5) == 0)
            return "Class C";

        return "Class D";
    }
}
