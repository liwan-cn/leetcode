class Solution {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n+1];
        List<Integer> numbers = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        factorial[0] = 1;
        for (int i = 1; i <= n; i++){
            factorial[i] = factorial[i-1] * i;
            numbers.add(i);
        }
        --k;
        for(int i = 1; i <= n; i++){
            int index = k / factorial[n-i];
            sb.append(numbers.remove(index));
            k %= factorial[n-i];
        }
        return sb.toString();
    }
}