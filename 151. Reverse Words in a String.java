public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        if (s.trim().length() == 0) return "";
        String[] list = s.split(" ");
        int end = list.length;
        //while (list[--end].equals(""));
        StringBuilder sb = new StringBuilder();
        for (int i = end-1; i >= 0; i--){
            if (!list[i].equals("")) {
                sb.append(list[i]);
                if (i != 0) sb.append(" ");
            }
        }
        return sb.toString();
    }
}