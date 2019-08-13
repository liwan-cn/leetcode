class Solution {
    public int coinChange(int[] coins, int amount) {
        int []count = new int[amount + 1];
        Arrays.fill(count, Integer.MAX_VALUE);
        count[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if(count[j - coins[i]] != Integer.MAX_VALUE) {
                    count[j] = Math.min(count[j], count[j - coins[i]] + 1);
                }
            }
        }
        return count[amount] == Integer.MAX_VALUE ? -1 : count[amount];
    }
}