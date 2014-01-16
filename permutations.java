Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
         ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
         ArrayList<Integer> list = new ArrayList<Integer>();
         helper(rst, list, num);
         return rst;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> rst, ArrayList<Integer> list, int[] num){
        if(list.size() == num.length) {
            rst.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i<num.length; i++){
            if(list.contains(num[i])){
                continue;
            }
            list.add(num[i]);
            helper(rst, list, num);
            list.remove(list.size() - 1);
        }
        
    }
    
 
}

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].


public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] visited = new int[num.length];
        
        Arrays.sort(num);
        helper(result, list, visited, num);
        return result;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] visited, int[] num){
        if(list.size() == num.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i<num.length; i++){
            // num[i] has been visited, or it's previous same number has been visited before backtracking; 
            // therefore, note here is visited[i-1]==0 
            if (visited[i] == 1 || (i!=0 && num[i] == num[i-1] && visited[i-1] == 0)){
                continue;
            }
            visited[i] = 1;
            list.add(num[i]);
            helper(result, list, visited, num);
            list.remove(list.size()-1);
            visited[i] = 0;
        }
    }
    
}
