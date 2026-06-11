class Solution {
    public int maxProfit(int[] prices) {    
        int left = 0;
        int max = 0;

        for (int i = 1; i < prices.length; i++)
        {

            if (prices[left] > prices[i])
            {
                left = i;
                continue;
            }
            else
            {
                max = Math.max(max, prices[i] - prices[left]);
            }
        }
        
        return max;
    }
}
