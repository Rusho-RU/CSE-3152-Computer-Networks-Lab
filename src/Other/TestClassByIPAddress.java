package Other;

public class TestClassByIPAddress {
    public static void main(String[] args){
        ClassByIPAddress classByIPAddress = new ClassByIPAddress("255.255.123.123");
        String string = classByIPAddress.getClassName();

        System.out.println(string);
    }
}
