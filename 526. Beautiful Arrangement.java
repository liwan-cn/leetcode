class Solution {

    private int count = 0;

    public int countArrangement(int N) {
        count = 0;
        helper(N, 1, new boolean[N + 1]);
        return count;
    }

    private void helper(int N, int pos, boolean[] used) {
        if (pos > N) {
            count++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!used[i] && (i % pos == 0 || pos % i == 0)) {
                used[i] = true;
                helper(N, pos + 1, used);
                used[i] = false;
            }
        }
    }
}