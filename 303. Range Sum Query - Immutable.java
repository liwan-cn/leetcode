class NumArray {
    
    int [] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        for(int i = 1; i < nums.length; i++)
            this.nums[i] += nums[i - 1];
    }
    
    public int sumRange(int i, int j) {
        if(i == 0)
            return this.nums[j];
        return this.nums[j] - this.nums[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */