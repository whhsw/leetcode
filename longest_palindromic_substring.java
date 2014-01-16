Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

Discuss



public class Solution {
    
    // 1. dp[i][j] to store whether s[i:j] is palindrome, this will cost O(n^2) in both time, space
    // 2. use i as center, go left, go right, O(n^2) time, O(1) space; insert a dummy # between each characer to make it easier
    // 3. there is a solution that can do O(n) time, O(1) space 
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        
        int n = s.length();    
        int max = 0;
        String result = "";
        for(int i = 1; i <= 2 * n - 1; i++){
            int count = 1;
            while(i-count>=0 && i+count <= 2*n  && get(s, i-count) == get(s, i+count)){
                count ++;
            }
            count --; // there will be one extra count for the outbound #
            if(count > max){
                result = s.substring((i-count)/2, (i+count)/2);
                max = count;
            }
        }
        
        return result;
    }
    
    private char get(String s, int i){
        if(i % 2 == 0)
            return '#';
        else 
            return s.charAt(i/2);
    }
}
