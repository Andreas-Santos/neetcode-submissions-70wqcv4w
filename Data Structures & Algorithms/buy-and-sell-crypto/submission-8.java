class Solution {
    public int maxProfit(int[] prices) {

        int profit = 0;

        int l = 0;
        for(int r = 1; r < prices.length; r++) {

            if(prices[l] < prices[r]) {
                profit = Math.max(profit, prices[r] - prices[l]);
    
            }
            else {
                l = r;
            }
        }

        return profit;
    }
}
