Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.

public class Solution {
    
    // should be O(n)
    public boolean search(int[] A, int target) {
        assert(A!=null);
        int start = 0, 
            end = A.length-1;
            
        while(start<=end){
            int mid = (start+end)/2;
            if(A[mid]==target)
                return true;
            if(A[mid]<target){
                if(A[end]<A[mid] || A[end]>=target)
                    start=mid+1;
                else if(A[end]>A[mid] && A[end]<target)
                    end=mid-1;
                else
                    end--;
            }else{
                if(A[end]>A[mid] || A[end]<target){
                    end=mid-1;
                }else if(A[end]<A[mid] && A[end]>=target)
                    start=mid+1;
                else
                    end--;
            }
         
        }
        return false;
    }
}


