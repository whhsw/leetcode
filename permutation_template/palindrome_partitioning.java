/*
 *Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
 *
 * */

public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> rst = new ArrayList<ArrayList<String>>();
        ArrayList<String> list = new ArrayList<String>();
        
        helper(rst, list, s, 0);
        return rst;
    }
    
    public void helper(ArrayList<ArrayList<String>> rst, ArrayList<String> list, String s, int start){
        if(start == s.length()){
            rst.add(new ArrayList<String>(list));
            return;
        }
        
        for(int i=start; i<s.length(); i++){
               if (is_valid(s.substring(start, i+1))){
                   list.add(s.substring(start, i+1));
                   helper(rst, list, s, i+1);
                   list.remove(list.size()-1);
               }

        }
    }
    
    public boolean is_valid(String s){
        int start = 0;
        int end = s.length() - 1;
        while(start <= end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
    

}
