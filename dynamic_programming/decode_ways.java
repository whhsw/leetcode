A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.


public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;
        
        int[] count = new int[s.length() + 1];
        count[0] = 1;
        count[1] = 1;
            
        for(int i=2; i<= s.length(); i++) {
            if (is_valid(s.substring(i-2, i))){
                count[i] += count[i-2];
            }
            if (is_valid(s.substring(i-1, i))) {
                count[i] += count[i-1];
            }
        }
        return count[s.length()];
    }
    
    public boolean is_valid(String s){
        int d = Integer.valueOf(s);
        if(s.length() == 2)
            return d >= 10 && d <= 26;
        else 
            return d >=1;
    }
}
