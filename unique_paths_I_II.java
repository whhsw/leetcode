A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

public class Solution {
    
    // C(m+n, n)
    // method 2: DP, O(m*n) time, O(min(m,n)) space
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0)
            return 0;
        
        int[] count = new int[n];
        count[0] = 1;
        
        for(int i=0; i< m; i++){
            for(int j=1; j<n; j++){
                count[j] = count[j-1] + count[j];
            }
        }
        
        return count[n-1];
    }
}


Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.


public class Solution {
    public int uniquePathsWithObstacles(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0][0] == 1)
            return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[] count = new int[cols];
        count[0] = 1;
        for(int i=0; i< rows; i++){
            if(matrix[i][0] == 1) count[0] = 0;
            for(int j=1; j<cols; j++){
                if(matrix[i][j] == 1)
                    count[j] = 0;
                else
                    count[j] = count[j-1] + count[j];
            }
        }
        return count[cols-1];
    }
}
