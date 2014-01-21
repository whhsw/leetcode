Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.

public class Solution {
    // for any i, the maxium area will be the farthest j that has a[j] > a[i];
    public int maxArea(int[] height) {
        if(height == null || height.length < 2)
            return 0;
        int max = 0;
        int l = 0;
        int r = height.length -1;
        while(l < r){
            max = Math.max( max, (r - l)  * Math.min(height[l], height[r]));
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return max;
        
    }
}