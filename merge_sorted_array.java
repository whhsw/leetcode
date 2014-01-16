Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int pa = m-1;
        int pb = n-1;
        while(pa >=0 && pb >=0){
            if(A[pa] <= B[pb]){
                A[pa+pb+1] = B[pb];
                pb--;
            }else{
                A[pa+pb+1] = A[pa];
                pa--;
            }
        }
        while(pb >= 0){
            A[pb] = B[pb];
            pb --;
        }
    }
}
