class Solution {
    public int cmp(String s1, String s2){
        if (s1.equals(s2)) return 0;
        int l1 = s1.length(), l2 = s2.length();
        for (int i = 0; i < l1 && i < l2; i++){
            if (s1.charAt(i) < s2.charAt(i)) return 1;
            if (s1.charAt(i) > s2.charAt(i)) return -1;
        }
        if (l1 < l2) return cmp(s1, s2.substring(l1, l2));
        if (l1 > l2) return cmp(s1.substring(l2, l1), s2);
        return 0;
    }
    public String largestNumber(int[] nums) {
        Integer[] numsObj = new Integer[nums.length];
        for (int i  = 0; i < nums.length; i++){
            numsObj[i] = nums[i];
        }
        Arrays.sort(numsObj, 
                   (i1, i2) -> cmp(String.valueOf(i1), String.valueOf(i2))
        );
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while(start < numsObj.length-1 && numsObj[start].intValue() == 0) start++;
        for (int i = start; i < numsObj.length; i++){
            sb.append(String.valueOf(numsObj[i]));
        }
        return sb.toString();
    }
}