package Experiment13;

import java.util.Random;

public class HammingCode {
    private StringBuilder code;
    private int[] pow2 = new int[32];
    private StringBuilder encoded;
    private StringBuilder changedCode;
    private StringBuilder correctedCode;

    HammingCode(StringBuilder _code){
        code = _code;
        encoded = _code;
        init();
    }

    HammingCode(){
        init();
    }

    private void init(){
        pow2[0] = 1;
        for(int i=1; i<32; i++){
            pow2[i] = pow2[i-1]*2;
        }
    }

    private void addParityBits(){
        int highest=0;

        for(int i=0; pow2[i]<=encoded.length(); i++){
            encoded.insert(pow2[i]-1, '#');
            highest = i;
        }

        for(int i=0; i<=highest; i++){
            int cnt = 0, j=pow2[i]-2;
            while(++j < encoded.length()) {
                int count = 0;
                while (++count <= pow2[i] && j<encoded.length()) {
                    if (encoded.charAt(j++) == '1')
                        cnt++;
                }
                j+=pow2[i]-1;
            }

            if(cnt%2==0){
                encoded.setCharAt(pow2[i]-1, '0');
            }
            else{
                encoded.setCharAt(pow2[i]-1, '1');
            }
        }
    }

    public StringBuilder encode(){
        addParityBits();
        return encoded;
    }

    public StringBuilder encode(StringBuilder _encoded){
        encoded = _encoded;
        addParityBits();
        return encoded;
    }

    public StringBuilder changeRandomlySelectedBit(){
        Random random = new Random();
        int index = random.nextInt(encoded.length());
        changedCode = encoded;

        if(encoded.charAt(index)=='0') changedCode.setCharAt(index, '1');
        else changedCode.setCharAt(index, '0');

        return changedCode;
    }

    public StringBuilder changeRandomlySelectedBit(StringBuilder encoded){
        Random random = new Random(encoded.length()-1);
        int index = random.nextInt();

        if(encoded.charAt(index)=='0') changedCode.setCharAt(index, '1');
        else changedCode.setCharAt(index, '0');

        return changedCode;
    }

    public int detectError(){
        int highest=0, pos = 0;

        for(int i=0; pow2[i]<=changedCode.length(); i++){
            highest = i;
        }

        for(int i=0; i<=highest; i++){
            int cnt = 0, j=pow2[i]-2;
            while(++j < changedCode.length()) {
                int count = 0;
                while (++count <= pow2[i] && j<changedCode.length()) {
                    if (changedCode.charAt(j++) == '1')
                        cnt++;
                }
                j+=pow2[i]-1;
            }

            if(cnt%2==1){
                pos+=pow2[i];
            }
        }

        return pos;
    }

    public int detectError(StringBuilder changedCode){
        int highest=0, pos = 0;

        for(int i=0; pow2[i]<=changedCode.length(); i++){
            highest = i;
        }

        for(int i=0; i<=highest; i++){
            int cnt = 0, j=pow2[i]-2;
            while(++j < changedCode.length()) {
                int count = 0;
                while (++count <= pow2[i] && j<changedCode.length()) {
                    if (changedCode.charAt(j++) == '1')
                        cnt++;
                }
                j+=pow2[i]-1;
            }

            if(cnt%2==1){
                pos+=pow2[i];
            }
        }

        return pos;
    }

    public StringBuilder correctError(){
        correctedCode  = changedCode;
        int index = detectError(correctedCode);

        if(correctedCode.charAt(index-1)=='1')
            correctedCode.setCharAt(index - 1, '0');

        else
            correctedCode.setCharAt(index - 1, '1');

        return correctedCode;
    }

    public StringBuilder correctError(StringBuilder changedCode){
        int index = detectError(changedCode) - 1;

        if(changedCode.charAt(index)=='1')
            changedCode.setCharAt(index, '0');

        else
            changedCode.setCharAt(index, '1');

        return changedCode;
    }

    public String getOriginal(){
        String original = "";

        for(int i=0, j=0; i<correctedCode.length(); i++){
            if(i==pow2[j]-1){
                j++;
            }

            else
                original += correctedCode.charAt(i);
        }

        return original;
    }
}