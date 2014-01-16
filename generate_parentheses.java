Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> rst = new ArrayList<String>();
        if(n == 0)
            return rst;
        
        getPair(rst, "", n, n);
        return rst;
    }
    
	public void getPair( ArrayList<String> rst , String s, int l, int r){
		if(l > r || l < 0 || r < 0)
			return; 	
			
		if(l == 0 && r == 0){
			rst.add(s);
			return;
		}

		getPair(rst, s+"(", l-1, r);
		getPair(rst, s+")", l, r-1);
	}
	
}
