class Solution {
    public int mySqrt(int x) {
        if (0 == x) return 0;
        int left = 1, right = x;
        while (left <= right) {
            int mid = (left + right ) >> 1;
            if (mid <= x / mid && (mid+1) > x / (mid+1))  //mul can overflow
                return mid;
            if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 1;
    }
}