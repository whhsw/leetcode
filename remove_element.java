Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

public class Solution {
    public int removeElement(int[] A, int elem) {
        int i = 0;
        int pointer = A.length - 1;
        while(i <= pointer){
            if(A[i] == elem){
                A[i] = A[pointer];
                pointer --;
            }else{
                i++;
            }
        }
        return pointer+1;
    }
}
