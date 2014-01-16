Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Discuss


public class Solution {
    public int minPathSum(int[][] grid) {
        if ( grid == null || grid.length == 0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[] sum = new int[cols];
        Arrays.fill(sum, Integer.MAX_VALUE);
        sum[0] = 0;
        for(int i = 0; i < rows; i++){
            sum[0] = grid[i][0] + sum[0];
            for(int j = 1; j< cols; j++){
                sum[j] = Math.min(sum[j], sum[j-1]) + grid[i][j];
            }
        }
        
        return sum[cols-1];
    }
}
