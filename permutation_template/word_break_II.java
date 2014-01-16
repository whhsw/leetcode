/*
 *Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
 *
 *
 * */


public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> rst = new ArrayList<String>();
        helper(rst, "", s, dict, 0);
        return rst;
    }
    
    public void helper(ArrayList<String> result, String solution, String s, Set<String> dict, int start){
        if(start == s.length()){
            result.add(solution);
            return;
        }
        
        for(int i=start; i < s.length(); i++){
            String tmp = s.substring(start, i+1);
            if(dict.contains(tmp)){
                helper(result, solution + " " + tmp, s, dict, i+1);
            }
        }
    }
    
    
    
    
    public ArrayList<String> wordBreak2_slow(String s, Set<String> dict) {
        ArrayList<String> rst = new ArrayList<String>();
        if(s == null || dict == null || s.length() == 0){
            return rst;
        }
        
      
        ArrayList<ArrayList<String>> dp = new ArrayList<ArrayList<String>>();
        for(int i=0; i <= s.length(); i++){
        	dp.add(new ArrayList<String>());
        }
        
        dp.get(0).add("");
        for(int i=0; i<s.length(); i++){
        	ArrayList<String> current = dp.get(i);
            if (current.isEmpty()) continue;
            for(String word: dict){
                for(String prefix: current){
                    if(s.substring(prefix.replaceAll("\\s+","").length()).indexOf(word) == 0){
                    	int index = i + word.length();
                        dp.get(index).add((prefix + " " + word).trim());
                    }
                }
            }
        }
        
        return dp.get(s.length());
    }
}
