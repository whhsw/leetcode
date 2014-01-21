/*
 *
 *Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
 *
 * */public class Solution {
    // DP, dp[i] stands for whether it can be splitted till position i
     public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict.isEmpty()){
            return false;
        }
        
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i= 0; i < s.length(); i++){
            if(!dp[i]) continue;
            for(String word: dict){
                if (s.substring(i).indexOf(word) == 0)
                    dp[i+word.length()] = true;
            }
        }
        
        return dp[s.length()];
    }
    
    
    

// Recursive is a too slow...
    public boolean wordBreak_recursive(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict.isEmpty()){
            return false;
        }
        
        return find(s, dict);
    }
    
    public boolean find(String s, Set<String> dict){
        if(s == "")
            return true;
        for(String word: dict){
            if (s.indexOf(word) == 0){
                find(s.substring(word.length()), dict);
            }
        }
        return false;
    }
}
