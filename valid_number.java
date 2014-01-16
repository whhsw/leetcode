Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

public class Solution {
    public boolean isNumber(String s) {
		if(s == null || s.length() == 0)
			return false;
		//check for pos/neg digit/decimal
//		if(s.matches("\\-?\\d+\\.?\\d*"))  // +: 1 or n,  ? : 1 or 0,  *: 0 or n
//			return true;
        s = s.trim();
        if(s.length() == 0)
            return false;
            
        if(s.charAt(0) == '+' || s.charAt(0) == '-')
            s = s.substring(1);
        
		if(s.matches("\\d+\\.?\\d*"))  //
			return true;
        
		if(s.matches("\\d+(\\.\\d+)?"))  // +: 1 or n,  ? : 1 or 0,  *: 0 or n
			return true;
		if(s.matches("\\.\\d+"))  // +: 1 or n,  ? : 1 or 0,  *: 0 or n
			return true;
		if(s.matches("\\d+\\.?\\d*e\\-?\\d+"))  // scientific notation
			return true;
		if(s.matches("\\d+/\\d+"))  //fraction
			return true;
		return false;
    }
}

