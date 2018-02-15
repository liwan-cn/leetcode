class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int max = 0;
        int min = prices[0];
        for(int price : prices){
            max = Math.max(max,price-min);
            min = Math.min(min,price);   
        }
        return max;
    }
}