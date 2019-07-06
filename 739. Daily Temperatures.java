''class Solution {
    public int[] dailyTemperatures(int[] T) {
        int []res = new int[T.length];
        if (T.length == 0) return res;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1, l = T.length; i < l; i++){
            while (!stack.isEmpty() && T[i] > T[stack.peek()]){
                int index = stack.peek();
                res[index] = i - index;
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}