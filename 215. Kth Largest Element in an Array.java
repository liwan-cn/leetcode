class Solution {
    /******分治法实现********/
    public int findKthLargest(int[] nums, int k) {
        return partition(nums, 0, nums.length-1, k-1);
    }
    public int partition(int []nums, int s, int e, int k){
        int pivot = nums[s];
        int i = s, j = e;
        while(i < j){
            while(j > i && nums[j] <= pivot) j--;
            nums[i] = nums[j];
            while(j > i && nums[i] > pivot) i++;
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        if (i == k) return pivot;
        if (i < k) return partition(nums, i + 1, e, k);
        return partition(nums, s, i - 1, k);
    }

    /******堆排序实现*******/
    /*
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();//(i1, i2) -> (i1 - i2)
        for (int i = 0; i < k && i < nums.length; i++){
            q.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++){
            if (nums[i] > q.peek()){
                q.poll();
                q.add(nums[i]);
            }
        }
        return q.peek().intValue();
    }
    */
}