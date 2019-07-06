class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder re = new StringBuilder();
        Arrays.sort(strs);
        if (strs!= null && strs.length > 0){
            char []start = strs[0].toCharArray();
            char []end = strs[strs.length-1].toCharArray();
            for(int i = 0; i < start.length; i++){
                if(start[i] == end[i]) re.append(start[i]);
                else return re.toString();
            }
        }
        return re.toString();
    }
}