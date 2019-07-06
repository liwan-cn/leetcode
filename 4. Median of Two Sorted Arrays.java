class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = (nums1.length + nums2.length + 1) >> 1;
        int r = (nums1.length + nums2.length + 2) >> 1;
        return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;
    }
    private double getKth(int []A, int a, int []B, int b, int k){
        if (a > A.length - 1) return B[b + k - 1];
        if (b > B.length - 1) return A[a + k - 1];
        if (k == 1) return Math.min(A[a], B[b]);
        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (a + k / 2 - 1 < A.length) aMid = A[a + k / 2 - 1];
        if (b + k / 2 - 1 < B.length) bMid = B[b + k / 2 - 1];
        if (aMid < bMid)
            return getKth(A, a + k / 2, B, b, k - k / 2);
        else
            return getKth(A, a, B, b + k / 2, k - k / 2);
    }
}