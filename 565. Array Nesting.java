class Solution {
    //set{index} = set{num} 所以从任何一个节点出发 必定成环
    // 不可能存在有两个元素指向同一个位置
    public int arrayNesting(int[] nums) {
        int max  = 0;
        for (int i = 0; i < nums.length; i++){
            int size = 0;
            for (int k = i; nums[k] >= 0; size++){
                int tmp = nums[k];
                nums[k] = -1;
                k = tmp;
            }
            max = Math.max(max, size);
        }
        return max;
    }
}