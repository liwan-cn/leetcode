class Solution {
    public String largestNumber(int[] nums) {
        String[] numsStr = new String[nums.length];
        for (int i  = 0; i < nums.length; i++)
            numsStr[i] = String.valueOf(nums[i]);
        Arrays.sort(numsStr, (i1, i2) -> (i1 + i2).compareTo(i2 + i1));
        StringBuilder res = new StringBuilder();
        if (numsStr[numsStr.length - 1].equals("0")) return "0";
        for (int i = numsStr.length - 1; i >= 0; i--)
            res.append(numsStr[i]);
        return res.toString();
    }
}