class Solution {
    public int thirdMax(int[] nums) {
        Integer f = null, s = null, t = null;
        for (int i = 0; i < nums.length; i++){
            if (f == null || nums[i] >= f){
                if (f == null || nums[i] > f){
                    t = s; s = f; f = nums[i]; 
                }
                //continue;
                
            }  else if (s == null || nums[i] >= s){
                if (s == null || nums[i] > s){
                    t = s; s = nums[i];
                }
                //continue;
                
            } else if (t == null || nums[i] >= t){
                if (t == null || nums[i] > t){
                    t = nums[i];
                }
                //continue;
            }
            //System.out.println(f + ";" + s + ";" + t);
        }
        if (t == null) return f;
        return t;
    }
}