Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        
        helper(rst, list, 0, candidates, target);
        return rst;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> rst, ArrayList<Integer> list, int start, int[] candidates, int target){
        if(target == 0){
            rst.add(new ArrayList<Integer>(list));
            return;
        }
        
        if(target < 0)
            return;
        
        for(int i = start; i < candidates.length; i++) {
            if( i!= start && candidates[i] == candidates[i-1])  // remove the duplicates
                continue;
            list.add(candidates[i]);
            helper(rst, list, i, candidates, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);
        
        helper(rst, list, 0, num, target);
        return rst;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> rst, ArrayList<Integer> list, int start, int[] candidates, int target){
        if(target == 0){
            rst.add(new ArrayList<Integer>(list));
            return;
        }
        
        if(target < 0)
            return;
        
        for(int i = start; i < candidates.length; i++) {
            if( i!= start && candidates[i] == candidates[i-1])  // remove the duplicates
                continue;
                
            list.add(candidates[i]);
            helper(rst, list, i + 1, candidates, target - candidates[i]);  
            // the only difference is combination one use i, this one use i+1
            list.remove(list.size() - 1);
        }
    }
}
