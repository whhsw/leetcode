/*
 *Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 *
 * */


public class Solution {
    public boolean isPalindrome(String s) {
        int a = 0;
        int b = s.length() - 1;
        while(a < b){
            while(a < s.length() && !isvalid(s.charAt(a))){  // nead to check range of a/b
                a++;
            }
            
            if(a == s.length()) 
                return true; // for emtpy string “.,,,”
            
            while(b >=0 && ! isvalid(s.charAt(b))){ // same here, need to check border of a,b
                b--;
            }
            
            if(Character.toLowerCase(s.charAt(a)) != Character.toLowerCase(s.charAt(b))){
                break;
            }else{
                a++;
                b--;
            }
        }
        
        return b <= a; 
    }
    
    private boolean isvalid(char c){
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
