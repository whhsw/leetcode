Divide two integers without using multiplication, division and mod operator.

Discuss



// 1. by doing minus each time, it will be supper slow for cases like	2147483647, 1
// kinds of recursion, divisor * 2 each time;

public class Solution {
    public int divide(int dividend, int divisor) {
       
        int rst = divide_helper(Math.abs(dividend), Math.abs(divisor));
        if( (dividend < 0 && divisor < 0) || (dividend > 0 && divisor >0) ){
            return rst;
        }else
            return -rst;
    }
    
    private int divide_helper(int d1, int d2){
        int result = 0;
        int k = 1;
        int tmp_d2 = d2;
        while(d1 >= d2){
            result += k;
            d1 -= tmp_d2;
            tmp_d2 += tmp_d2;  // d2 * 2
            k += k;    // k * 2;
        }
        if (d1 >= d2){
            result += divide_helper(d1, d2);
        }
        return result;
    }
    
}
