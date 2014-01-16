// Return solution

public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> rst = new ArrayList<String[]>();
        int[] solution = new int[n];
        helper(rst, solution, 0, n);
        return rst;
    }
    
    public void helper(ArrayList<String[]> rst, int[] solution, int row, int n){
        if(row == n){
            String[] tmp = new String[n];
            for(int i = 0; i < n; i++) {
                char[] c = new char[n];
                Arrays.fill(c, '.');
                c[solution[i]] = 'Q';
                tmp[i] = new String(c);
            }
            rst.add(tmp);
            return;
        }
        
        for(int i = 0; i< n; i++){
            solution[row] = i;
            if(isvalid(solution, row)){
                helper(rst, solution, row+1, n);
            }
        }
    }
    
    private boolean isvalid(int[] solution, int row){
        for(int i = 0; i < row; i++){
            int diff = solution[i] - solution[row];
            if(diff == 0 || Math.abs(diff) == row - i)
                return false;
        }
         return true;
    }
    
}


// Return total counts of solution

public class Solution {
    public int totalNQueens(int n) {
        int[] solution = new int[n];
        return helper(solution, 0, n);
    }
    
    public int helper(int[] solution, int row, int n){
        if(row == n){
            return 1;
        }
        
        int count = 0;
        for(int i = 0; i< n; i++){
            solution[row] = i;
            if(isvalid(solution, row)){
                count += helper(solution, row+1, n);
            }
        }
        return count;
    }
    
    private boolean isvalid(int[] solution, int row){
        for(int i = 0; i < row; i++){
            int diff = solution[i] - solution[row];
            if(diff == 0 || Math.abs(diff) == row - i)
                return false;
        }
         return true;
    }
    
}

