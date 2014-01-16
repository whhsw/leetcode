Implement strStr().

public class Solution {
    public String strStr(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() < s2.length())
            return null;
        
        for(int i = 0; i <= s1.length() - s2.length(); i++) {
            int j = 0;
            for(j = 0; j < s2.length(); j++){
                if(s1.charAt(i+j) != s2.charAt(j)) {
                    break;
                }
            }
            if( j == s2.length())
                return s1.substring(i);
        }
        
        return null;
    }
}
