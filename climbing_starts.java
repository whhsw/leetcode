You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

public class Solution {
    public int climbStairs(int n) {
        if(n == 0)
            return 0;
        int a = 1;
        int b = 2;
        for(int i=1; i<n; i++){
            int tmp = a + b;
            a = b;
            b = tmp;
        }
        
        return a;
    }
}
