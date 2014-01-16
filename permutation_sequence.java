The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.

public class Solution {
    // first digit is k / (n-1)!, permcount1 = (n-1)!
    // second digit: k = k % permcount1,  k / (n-2)!
    // k should be within [1, n!]
    public String getPermutation(int n, int k) {
        k --;  // 1th digit is actually the 0th
        StringBuffer sb = new StringBuffer();
        
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int fac = 1;
        for(int i=1; i<=n; i++){
            nums.add(i);
            fac *= i;   // get n!
        }
        
        for(int i = n; i>=1; i--){
            fac /= i;
            int digit = k / fac;
            sb.append(nums.get(digit));
            nums.remove(digit);
            k %= fac;
        }
        
        return sb.toString();
    }
}
