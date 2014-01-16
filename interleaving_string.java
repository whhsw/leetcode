Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.


public class Solution {
    // 2d DP problem
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1=="" || s2 == ""){
            return (s1+s2).equals(s3);
        }
        
        if(s3.length() != s1.length() + s2.length())
            return false;
        
        boolean[][] rst = new boolean[s1.length() + 1][s2.length() + 1];

        rst[0][0] = true;
        for(int i=0; i < s1.length(); i++){
            if( s1.charAt(i) == s3.charAt(i))
                rst[i+1][0] = true;
            else 
                break;
        }
        
        for(int i=0; i<s2.length(); i++){
            if( s2.charAt(i) == s3.charAt(i))
                rst[0][i+1] = true;
            else 
                break;
        }

        for(int i = 1; i <= s1.length(); i++){
            for(int j=1; j<= s2.length(); j++){
                rst[i][j] = 
                    (s3.charAt(i+j-1) == s1.charAt(i-1) && rst[i-1][j])
                    || (s3.charAt(i+j-1) == s2.charAt(j-1) && rst[i][j-1]);

            }
        }
        
        return rst[s1.length()][s2.length()];  
    }
}
