package Experiment13;

public class testHammingCode {
    public static void main(String[] args){
        StringBuilder code  = new StringBuilder("10110011");
        HammingCode hammingCode = new HammingCode(code);
        System.out.println("Code word: " + hammingCode.encode());
        System.out.println("After randomly alter a single bit the receiving code word is: " + hammingCode.changeRandomlySelectedBit());
        System.out.println("Error Found in Position: " + hammingCode.detectError() + " (from left)");
        hammingCode.correctError();
        System.out.println("The Original data is: " + hammingCode.getOriginal());
    }
}
