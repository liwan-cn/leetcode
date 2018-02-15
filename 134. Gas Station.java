class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, tank = 0, sum = 0;
        for (int i = 0; i < gas.length; i++){
            tank += gas[i] - cost[i];
            sum += tank;
            if (tank < 0){
                start = i + 1;
                tank = 0;
            }
        }
        return (sum >= 0) ? start : -1;
    }
}