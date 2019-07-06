class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, res = 0;
        for (int price : prices){
            res = Math.max(res, price - min);
            min = Math.min(min, price);
        }
        return res;
    }
}