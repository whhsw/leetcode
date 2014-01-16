Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.

public class Solution {
    
    // O(n), start scan from the begining, once find repeat, recalculate the current max
    // if not using hashmap, then O(1) space, O(n^2) time
    public int lengthOfLongestSubstring(String s) {
         if(s == null || s.length() == 0)
            return 0;
         
         int max = 0;
         int current_max = 0;
         int tracking = 0;
         HashMap<Character, Integer> position = new HashMap<Character, Integer>();
         for(int i = 0; i< s.length(); i++){
             char c = s.charAt(i);
             if(! position.containsKey(c)){
                 current_max ++;
                 position.put(c, i);
             }else{
                 max = Math.max(max, current_max);
                 current_max = i - position.get(c);
                 while(s.charAt(tracking) != c){
                     position.remove(s.charAt(tracking));
                     tracking ++;
                 }
                 position.put(c, i);
                 tracking++;  // tracking alwasy point to the position to be removed
             }
         }
         
         
         return Math.max(max, current_max); // don't forget to compare the remanings 
    }
}
