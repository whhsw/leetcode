Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

public class Solution {
    public String minWindow(String S, String T) {
        int[] needToFind = new int[128];
        int[] hasFound = new int[128];
         
        for(int i = 0; i < T.length(); ++i) {
            needToFind[T.charAt(i)]++;
        }
         
        int count = 0;
        int minWindowSize = Integer.MAX_VALUE;
        int start = 0, end = 0;
        String window = "";
         
        for(; end < S.length(); end++) {
            if(needToFind[S.charAt(end)] == 0) continue;
            char c = S.charAt(end);
            hasFound[c]++;
             
            if(hasFound[c] <= needToFind[c]) {
                count++; // only counts when it is useful
            }
             
            if(count == T.length()) {
                // This is to move the start pointer
                char c = S.charAt(start);
                while(needToFind[c] == 0 || hasFound[c] > needToFind[c]) {
                    if(hasFound[c] > needToFind[c])
                        hasFound[c]--;
                    start++;
                    c = s.charAt(start);
                }
                 
                // update the sliding window
                if(end - start + 1 < minWindowSize) {
                    minWindowSize = end - start + 1;
                    window = S.substring(start, end + 1);
                }
            }
        }
         
        return window;
    }
}
