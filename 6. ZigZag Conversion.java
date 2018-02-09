class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1) return s;
        StringBuilder[] sb=new StringBuilder[numRows];
        for(int i = 0; i < sb.length; i++){
            sb[i] = new StringBuilder("");   //init every sb element **important step!!!!
        }
        int i = 0, len = s.length();
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++) // vertically down
                sb[idx].append(s.charAt(i++));
            for (int idx = numRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(s.charAt(i++));
        }
        String re = "";
        for(int j = 0;j < sb.length; j++){
            re += sb[j];
        }
        return re.toString();
    }
}