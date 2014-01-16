/*Given an array of integers, every element appears twice except for one. Find that single one. */
public class Solution {
    public int singleNumber(int[] A) {
        int rst = 0;
        for (int i = 0; i < A.length; i++) {
            rst ^= A[i];            
        }
        return rst;
    }
}
