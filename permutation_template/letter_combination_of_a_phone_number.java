Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.



public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> rst = new  ArrayList<String>();
        String[] pads = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(rst, digits, "", 0, pads);
        return rst;
    }
    
    public void helper( ArrayList<String> rst, String digits, String solution, int start, String[] pads){
        if(start == digits.length()){
            rst.add(solution);
            return;
        }
        
        int index = digits.charAt(start) - '0';
        for (char c: pads[index].toCharArray()) {
            helper(rst, digits, solution + String.valueOf(c), start+1, pads);
        }
    }
    
}
