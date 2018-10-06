class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for (int x : nums1) s1.add(x);
        for (int x : nums2) s2.add(x);
        s1.retainAll(s2);
        int[] res = new int[s1.size()];
        int cnt = 0;
        for (int x : s1) res[cnt++] = x;
        return res;
    }
}