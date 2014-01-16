Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1


public class Solution {
    public void nextPermutation(int[] num) {
        int index;

        // find the violating number which is not the first digit
        for(index = num.length -2; index>=0; index--){
            if (num[index] < num[index+1]){
                break;
            }
        }
        
        // right->left, find the first number which is larger than violating number
        if(index >= 0){
            for(int j = num.length - 1; j>=0; j--){
                if(num[j] > num[index]) {
                    swap(num, index, j);
                    break;
                }
            }
        }
        
        // revsere all digits after index;
        int start = index+1;
        int end = num.length -1;
        while(start <= end){
            swap(num, start, end);
            start++;
            end--;
        }
    }
    
    private void swap(int[] num, int i, int j){
                  int tmp = num[j];
                    num[j] = num[i];
                    num[i] = tmp;        
    }
}
