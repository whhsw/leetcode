public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        if(len % 2 == 1)
            return find(A, 0, B, 0, len/2 + 1);
        else
            return (find(A, 0, B, 0, len/2) + find(A, 0, B, 0, len/2 + 1)) / 2.0 ;
    }
    
    // find kth number of two sorted array
    public static int find(int[] a, int start1, int[]b, int start2, int k){		
		if(start1 >= a.length) 
			return b[start2 + k - 1];
		if(start2 >= b.length)
			return a[start1 + k - 1];

		if (k==1)
			return Math.min(a[start1], b[start2]);
		
		int pa = start1 + k/2 - 1 < a.length ? a[start1 + k/2 - 1] : Integer.MAX_VALUE;
		int pb = start2 + k/2 - 1 < b.length ? b[start2 + k/2 - 1] : Integer.MAX_VALUE; 
		
		if (pa < pb)
			return find(a, start1 + k/2, b, start2, k - k/2);
		else 
			return find(a, start1, b, start2 + k/2, k - k/2);
		
	}
    
}



