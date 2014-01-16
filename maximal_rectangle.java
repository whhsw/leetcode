Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.

public class Solution {
    // 1. for each column,updates with # of consecutive 1s;
    // 2. for each row, it's the same as find out maximum rectangle in a histogram
    // O(n^2) + O(n^2)
    
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] tmp = new int[rows][cols];
        for(int j=0; j<cols; j++)
            tmp[0][j] = (int)(matrix[0][j] - '0');
        
        for(int i=1; i<rows; i++){
            for(int j=0; j<cols; j++){
                tmp[i][j] = matrix[i][j]=='0' ? 0 : (int)(matrix[i][j]- '0') + tmp[i-1][j];
            }
        }
        
        int max = 0;
        for(int i = 0; i<rows; i++){
            int row_max = largestRectangleArea(tmp[i]);
            max = Math.max(max, row_max);
        }
        return max;
    }
    
    
    
    
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
            }else{
                int h = height[s.pop()];
                while(!s.isEmpty() && height[s.peek()] == h){
                    s.pop();  // pop out all elements with the same height
                }
                int w = s.isEmpty() ? i : i - s.peek() - 1; // note that s can be emtpy after several pop
                max = Math.max(max, h * w);                
            }
        }
        
        return max;
    }
    
    
}
