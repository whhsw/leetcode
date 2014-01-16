You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).


public class Solution {
    
    // can't find better solution....  
    
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        String solution = "";
        boolean[] visited = new boolean[L.length];
        Arrays.sort(L);
        helper(rst, solution, visited, S, L, 0);
        return rst;
    }
    
    private void helper(ArrayList<Integer> rst, String solution, boolean[] visited, String s, String[] dict, int count){
        if(count == dict.length) {
            rst.add(s.indexOf(solution));
            return;
        }
        
        for(int i = 0; i < dict.length; i++){
            // check duplications
            if(visited[i] || ( i != 0 && dict[i] == dict[i-1] && !visited[i-1] )){
                continue;
            }
            
            if(! s.contains(solution + dict[i])){
                continue;
            }
            
            visited[i] = true;
            helper(rst, solution+dict[i], visited, s, dict, count+1);
            visited[i] = false;
        }
        
    }
}
