Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0



public class Solution {
    public int searchInsert(int[] a, int target) {
        int l = 0;
        int r = a.length - 1;
        while(l <= r){
            int mid = (l+r) / 2;
            if(a[mid] == target){
                return mid;
            }else if(a[mid] > target){
                r = mid -1;
            }else{
                l = mid +1;
            }
        }
        return l;
    }
}
