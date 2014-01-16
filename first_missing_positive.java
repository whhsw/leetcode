Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.

public class Solution {
    // 1. first thought, sum up all positive numbers, if sum == (min+max) * n /2, then return max+1, else return the diff
    // Only one scan needed, but this method will overflow when there are lots of digits. 

    // 2. second thought, it's similar to count sort; for each positive integer i, a[i-1] = i , O(n)
    public int firstMissingPositive(int[] A) {
        if(A == null || A.length == 0)
            return 1;
        for(int i = 0; i < A.length; i++){
            // A[i]<= 0: non-positive number, skip
            // A[i] == i+1 correct position;
            // A[i] > A.length:  [1,2,3,5], A[4] > A.length
            // A[i] == A[A[i] - 1]: A[A[i] - 1] is the correct position for A[i].
            
            while(!( A[i] <= 0 || A[i] == i+1 || A[i] > A.length || A[A[i] - 1] == A[i])){ 
                swap(A, i, A[i]-1);
            }
        }
        
        int i = 0;
        while( i < A.length && A[i] == i+1) {  // trick here, need to track the length 
            i++;
        }
        return i+1; // trick here , need to +1
    }
    
    private void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
