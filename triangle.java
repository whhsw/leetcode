/*
 *
 *Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 * */


public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        
        // if (triangle.size() == 1)   size() == 1 has been considered
        //     return triangle.get(0).get(0);
        
        for(int i=1; i<triangle.size(); i++){
            ArrayList<Integer> prev = triangle.get(i-1);
            ArrayList<Integer> curr = triangle.get(i);
            curr.set(0, curr.get(0) + prev.get(0));
            curr.set(i, curr.get(i) + prev.get(i-1));
            for(int j = 1; j < i; j++){
                curr.set(j, curr.get(j) + Math.min(prev.get(j-1), prev.get(j)));
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i: triangle.get(triangle.size()-1)){
            min = Math.min(min, i);
        }
        
        return min;
        
    }
}
