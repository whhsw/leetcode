Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

public class Solution {
    public int maxSubArray(int[] a) {
        if (a == null || a.length == 0){
            return 0;
        }
        
        int max_sum = a[0];
        int current_sum = 0;
        for(int i=0; i<a.length; i++) {
            current_sum += a[i];
            max_sum = Math.max(max_sum, current_sum);
            
            if(current_sum < 0){
                current_sum = 0;
            }
        }
        return max_sum;
    }
}
