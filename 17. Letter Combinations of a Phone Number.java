class Solution {
    public static String [] DIGIT2MAP = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
         List<String> result = new ArrayList<String>();
         if (digits.length() == 0) return result;
         addNext(result, "", digits, 0);
         return result;
    }
    public void addNext(List<String> result, String pre, String digits, int start){
        if(start == digits.length()){
            result.add(pre);
            return;
        }
        int len = DIGIT2MAP[digits.charAt(start) - '0'].length();
        String now = DIGIT2MAP[digits.charAt(start) - '0'];
        for (int i = 0; i < len; i++)
            addNext(result, pre + now.charAt(i), digits, start+1);
    }
}