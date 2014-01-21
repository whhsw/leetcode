Implement int sqrt(int x).

Compute and return the square root of x.


public class Solution {
    public int sqrt(int x) {
        long l = 0;   /// change from int to long to pass the test of long digits....
        long r = x;
        while(l <= r){
            long mid = l + (r-l)/2;
            long tmp = mid * mid;
            if( tmp == x){
                return (int)mid;
            }else if(tmp > x){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return (int)r;
    }
}
