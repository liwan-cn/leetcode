class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        StringBuilder []sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++){
            sb[i] = new StringBuilder("");
        }
        for (int i = 0, l = s.length(); i < l;){
            for (int idx = 0; idx < numRows && i < l; idx++)
                sb[idx].append(s.charAt(i++));
            for (int idx = numRows-2; idx >= 1 && i < l; idx--)
                sb[idx].append(s.charAt(i++));
        }
        StringBuilder re = new StringBuilder("");
        for(int j = 0; j < sb.length; j++){
            re.append(sb[j]);
        }
        return re.toString();
    }
}