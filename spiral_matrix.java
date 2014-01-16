Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].


public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0) 
            return rst;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = 0;
        while(count * 2 < rows && count * 2 < cols){
            for(int i = count; i < cols-count; i++)
                rst.add(matrix[count][i]);
            
            for(int i = count+1; i< rows-count; i++)
                rst.add(matrix[i][cols-count-1]);
            
            if(rows - 2 * count == 1 || cols - 2 * count == 1)  // if only one row /col remains
                break;
                
            for(int i = cols-count-2; i>=count; i--)
                rst.add(matrix[rows-count-1][i]);
                
            for(int i = rows-count-2; i>= count+1; i--)
                rst.add(matrix[i][count]);
            
            count++;
        }
        return rst;
    }
}


Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]


public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] rst = new int[n][n];
        int count = 0;
        int digit = 1;
        while(count * 2 < n){
            for(int i = count; i < n-count; i++){
                rst[count][i] = digit;
                digit ++;
            }
            
            for(int i = count+1; i < n-count; i++){
                rst[i][n-count-1] = digit;
                digit++;
            }
            
            if (n- count *2 == 1)
                break;
            
            for(int i = n-count-2; i>=count; i--){
                rst[n-count-1][i] = digit;
                digit++;
            }
            
            for(int i = n-count-2; i>=count + 1; i--){
                rst[i][count] = digit;
                digit++;
            }
            
            count ++;
        }
        
        
        return rst;
    }
}
