Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

public class Solution {
    public int search(int[] A, int target) {
        return search(A, 0, A.length-1, target);
    }
    
    public static int search(int[] a, int start, int end, int target){
		while(start <= end){
			int mid = (int) (start+end) / 2;
			if(target == a[mid])
				return mid;
		    if( a[mid] > target && (a[end] > a[mid] || a[end] < target)||
		        a[mid] < target && (a[end] > a[mid] && a[end] < target)) {
		            end = mid - 1;
		    }else{
		        start = mid+1;
		    }
		      
		}
		return -1;
	}
    
}
