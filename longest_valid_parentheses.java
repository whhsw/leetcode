Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.


public class Solution {
    // remember the position of the last non-matching; by counting the matching para will return wrong awnser
 
 public int longestValidParentheses_2(String s) {
    int maxLen = 0, last = -1;
    Stack<Integer> lefts = new Stack<Integer>();
    for (int i=0; i<s.length(); ++i) {
        if (s.charAt(i)=='(') {
            lefts.push(i);
        } else {
            if (lefts.isEmpty()) {   // no matching left
                last = i;
            } else {    // find a matching pair
                lefts.pop();
                int prev = lefts.isEmpty() ? lefts.peek() : last; 
                maxLen = Math.max(maxLen, i - prev); // update the length for each found pair
            }
        }
    }
    return maxLen;
}
  
    
    
    // wrong answer !!
    public int longestValidParentheses_wrong(String s) {
        int max = 0;
 
        Stack<Character> stack = new Stack<Character>();
        for(Character c: s.toCharArray()){
            int current_max = 0;
            if( "({[".contains(String.valueOf(c))){
                stack.push(c);
            }else{
                if (!stack.isEmpty() && is_valid(stack.peek(), c)){
                    stack.pop();
                    max += 2;
                }else{
                   stack.clear();
                   current_max = 0;
                   max = Math.max(max, current_max);
                }
            }
        }
        return max;
    }
    
    private boolean is_valid(char c1, char c2){
        return (c1 == '(' && c2 == ')') || 
        (c1 == '{' && c2 == '}') ||
        (c1 == '[' && c2 == ']');
    }
}
