/*
 *Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 * */

public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        
        rowIndex += 1;
        if (rowIndex == 0)
            return rst;
        
        rst.add(1);
        for(int i = 1; i < rowIndex; i++){
            ArrayList<Integer> tmp = new ArrayList<Integer>(i+1);
            for(int j =0; j< i+1; j++){
            	tmp.add(-1);
            }
            tmp.set(0, rst.get(0));
            tmp.set(i, rst.get(i-1));
            for(int j = 1; j<i; j++){
                tmp.set(j, rst.get(j-1)+rst.get(j));
            }
            rst = tmp;
        }
        return rst;        
    }
}
