Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

Discuss


public class Solution {
    public boolean canJump(int[] A) {
        int max = 0;
        for(int i = 0; i < A.length; i++){
            if (max >= A.length -1)
                return true;
            if (i > max)
                return false;
            max = Math.max(max, i+A[i]);
        }
        
        return max >= A.length-1;
    }
    
}

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)


public class Solution {
    
    public int jump(int A[]) {
		int steps = 0;
		int rb = 0;
		int rb_next = 0;  // don't update the steps until it has to jump to next point;
		for (int i = 0; i < A.length; ++i) {
			if (i > rb) {
				rb = rb_next;
				++steps;
			}
			rb_next = Math.max(rb_next, i+A[i]);
		}
		return steps;
    }
    
}
