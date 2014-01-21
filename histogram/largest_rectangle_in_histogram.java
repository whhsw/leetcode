Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.


public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        Stack<Integer> s = new Stack<Integer>();
        
        int max = 0;
        int i = 0;
        
        while(i <= height.length){
            int current_h = (i == height.length) ? -1 : height[i]; // fake the last one to be -1 to flush out all elements
            
            if(s.isEmpty() || current_h > height[s.peek()]){
                s.push(i);
                i++;
                continue;
            }
            
            int h = height[s.pop()];
            int w = s.isEmpty() ? i : i - s.peek() - 1; // note that s can be emtpy after several pop
            max = Math.max(max, h * w);                
        }
        
        return max;
    }
}
