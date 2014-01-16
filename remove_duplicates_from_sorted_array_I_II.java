Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].


public class Solution {
    public int removeDuplicates(int[] a) {
        if(a == null || a.length == 0)
            return 0;
        
        int p = 1;
        for(int i=1; i< a.length; i++){
            int j;
            for(j=0; j<p; j++){
                if(a[i] == a[j])
                    break;
            }
            
            if(j==p){
                swap(a, p, i);
                p++;
            }
        }
        
        return p;
    }
    
    private void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].


public class Solution {
    public int removeDuplicates(int[] a) {
        if(a == null || a.length == 0)
            return 0;
        
        int p = 1;
        for(int i=1; i< a.length; i++){
            int j;
            int count = 0;
            for(j=0; j<p; j++){
                if(a[i] == a[j]){
                    count ++;
                    if (count == 2)
                        break;
                }
            }
            
            if(j==p){
                swap(a, p, i);
                p++;
            }
        }
        
        return p;
    }
    
    private void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
