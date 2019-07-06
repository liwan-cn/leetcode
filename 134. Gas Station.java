class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, tank = 0, sum = 0;
        for (int i = 0; i < gas.length; i++){
            tank += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (tank < 0){
                start = i + 1;
                tank = 0;
            }
            //System.out.println(sum);
        }
        return (sum >= 0) ? start : -1;
    }
}