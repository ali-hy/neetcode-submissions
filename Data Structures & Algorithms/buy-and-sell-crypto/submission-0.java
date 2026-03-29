class Solution {
    public int maxProfit(int[] prices) {
        int s = 0, e = 0, res = 0;

        while (e < prices.length) {
            if (prices[e] < prices[s]) {
                s = e;
                continue;
            }
            int profit = prices[e] - prices[s];
            if (profit > res)
                res = profit;
            e++;
        }

        return res > 0 ? res : 0;
    }
}
