Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].


public class Solution {
    public int[] searchRange(int[] a, int target) {
        int l = 0;
        int r = a.length-1;
        int[] rst = new int[]{-1, -1};
        
        // Search for lower bound, remeber right index
        while(l <= r){
            int mid  = (l+r)/2;
            if(a[mid] < target){
                l = mid + 1;
            }else if(a[mid] > target){
                r = mid - 1;
            }else{
                r = mid - 1;
                rst[0] = mid;
            }
        }
        
        if(a[0] == -1)
            return rst;
            
        // search for upper bound, remember left index    
        l = 0;
        r = a.length-1;
        while(l <= r){
            int mid  = (l+r)/2;
            if(a[mid] > target){
                r = mid - 1;
            }else if(a[mid] < target){
                l = mid + 1;
            }else{
                l = mid + 1;
                rst[1] = mid;
            }
        }    

        return rst;
    }
}
