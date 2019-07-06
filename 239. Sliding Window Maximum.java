class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        int []res = new int[nums.length - k + 1];
        int cnt = 0;
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++){
            // 把队列尾部所有比新数小的都扔掉，保证队列是降序的
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i])
                q.pollLast();
            // 每当新数进来时，如果发现队列头部的数的下标，是窗口最左边数的下标，则扔掉
            while(!q.isEmpty() && i-k >= q.peekFirst())
                q.pollFirst();
            // 加入新数
            q.addLast(i);
            // 队列头部就是该窗口内第一大的
            if (i + 1 >= k) res[cnt++] = nums[q.peek()];
        }
        return res;
    }
}