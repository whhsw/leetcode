// I : at most one transaction

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        
        int min = Integer.MAX_VALUE;  // 只要记住当前最小的股价就可以了
        int profit = 0;
        for(int i: prices){
            min = i < min ? i : min;
            profit = (i-min) > profit ? i-min : profit;
        }
        
        return profit;
    }

// II:  as many transactions as you like
//
public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=0; i<prices.length -1; i++){
            int diff = prices[i+1] - prices[i];
            if(diff > 0)
                profit += diff;
        }
        
        return profit;
    }
}

// III : at most two transactions

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1){
            return 0;
        }
        
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        
        // DP from left to right;
        left[0] = 0;
        int min = prices[0];
        for(int i=1; i<prices.length; i++){
            min = Math.min( prices[i], min);
            left[i] = Math.max(left[i-1], prices[i] - min);
        }
        
        //DP from right to left;
        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for(int i=prices.length-2; i>=0; i--){
            max = Math.max(prices[i], max);
            right[i] = Math.max(right[i+1], max - prices[i]);
        }
        
        int profit = 0;
        for(int i=0; i < prices.length; i++){
            profit = Math.max(left[i] + right[i], profit);  // 注意最后的合并结果
        }
        return profit;
        
    }
}
