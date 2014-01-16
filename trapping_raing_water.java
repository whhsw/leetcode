Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!


public class Solution {
    
    // First thought: scan from left to right, mark i, if a[j]<a[i], sum the bar, if a[j] >= a[i], then that's it
    // area = a[i] * (j-i) -  sum_of_inner_bar; for each area, mark down the total max
    // also need to do this from right to left. 
    // and then this is convered to method 1 ==> for each bar, we care about both the left max & right max
    
    // Method1: for each bar i , the water it can contains = min(left_max_height, right_max_height) - height[i]
    // Scan from left & right to get the max before it self. and then scan to get the sum of container
    
    // Follow up: what if I want the max area? during the last scan, sum up when it's neighbour >=0; mark down the max
    public int trap(int[] a) {
        if (a == null || a.length <= 2)
            return 0;
        
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        for (int i = 1; i < a.length; i++){
            left[i] = Math.max(left[i-1], a[i-1]);
        }
        
        for(int i=a.length-2; i>=0; i--){
            right[i] = Math.max(right[i+1], a[i+1]);
        }
        
        int sum = 0;
        for(int i=1; i<= a.length-2; i++){
            int area = Math.min(left[i], right[i]) - a[i];
            if(area > 0)
                sum += area;
        }
        
        return sum;
    }
}
