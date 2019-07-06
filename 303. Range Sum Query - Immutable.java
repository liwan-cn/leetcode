class NumArray {
    int [] sums;
    public NumArray(int[] nums) {
        this.sums = nums;
        for(int i = 1; i < nums.length; i++)
            this.sums[i] += sums[i - 1];
    }

    public int sumRange(int i, int j) {
        if(i == 0)
            return this.sums[j];
        return this.sums[j] - this.sums[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */