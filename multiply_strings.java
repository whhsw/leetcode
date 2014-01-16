Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.

public class Solution {
    
    // need to re-write the program for several times..
    
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        
        int[] num = new int[num1.length() + num2.length()]; // it would not be larger than this
        for(int i = 0; i< num1.length(); i++){
            //int carry = 0;
            int digit1 = num1.charAt(num1.length() - 1 - i) - '0';
            for(int j = 0 ; j<num2.length(); j++){
                int digit2 = num2.charAt(num2.length() - 1 - j) - '0';
                int k = digit1 * digit2+ num[i+j];  // dont forget num[i+j]
                num[i+j] = k % 10;
                num[i+j+1] += k/10; // this is for carry
            }
        }
        
        // scan from right, move to the first non-zero digit
        int i = num.length -1 ;
        while(i>0 && num[i] == 0){
            i--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(i>=0){
            sb.append((char)('0' + num[i]));
            i--;
        }
        
        return sb.toString();
        
        
    }
}
