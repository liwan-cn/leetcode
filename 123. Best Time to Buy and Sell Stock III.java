class Solution {
    public int maxProfit(int[] prices) {
        /*
        global[i][j] : 当前到达第i天可以最多进行j次交易，最好的利润是多少
        local[i][j] : 当前到达第i天，最多可进行j次交易，并且最后一次交易在当天卖出的最好的利润是多少
                     global[i][j]=max(local[i][j],global[i-1][j])
                    local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)
                global[i-1][j-1]+max(diff,0): 交易不连续,local[i-1][j]+diff : 交易连续
        global[i-1][j-1] 加上今天的交易，如果今天赚钱（也就是前面只要j-1次交易，最后一次交易取当前天）
        local[i-1][j] 加上今天的差值（local[i-1][j]包含第i-1天卖出的交易，变成第i天卖出，不增加交易次数，
        无论diff是不是大于0都一定要加上，否则不满足local[i][j]必须在最后一天卖出）
        https://blog.csdn.net/linhuanmars/article/details/23236995
        */
        if (prices == null || prices.length == 0) return 0;
        int k = 2;
        int[] local = new int[k+1];
        int[] global = new int[k+1];
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i+1] - prices[i];
            for (int j = k; j >= 1; j--){
                local[j] = Math.max(global[j-1] + (diff > 0 ? diff : 0), local[j] + diff);
                global[j] = Math.max(local[j], global[j]);
            }
        }
        return global[k];

    }
}
