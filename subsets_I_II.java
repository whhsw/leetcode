Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]


public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();

        subsetsHelper(result, list, num, 0);
        return result;
    }
    
    public void subsetsHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer>list, int[] num, int start){
        result.add(new ArrayList<Integer>(list));
        for(int i=start; i < num.length; i++){
            list.add(num[i]);
            subsetsHelper(result, list, num, i+1);
            list.remove(list.size()-1);
        }
        
    }
}

Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]


public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);
        helper(rst, list, num, 0);
        
        return rst;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> rst, ArrayList<Integer> list, int[] num, int start){
        rst.add(new ArrayList<Integer>(list));
        
        for(int i=start; i< num.length; i++){
            if ( i != start && num[i] == num[i-1]){
                continue;
            }    
        
            list.add(num[i]);
            helper(rst, list, num, i+1);
            list.remove(list.size()-1);
        }
    }
}
