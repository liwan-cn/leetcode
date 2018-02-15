public class Solution {
    public String reverseWords(String s) {
        if (s.trim().length() == 0) return "";
        String[] list = s.split(" ");
        int end = list.length;
        while (list[--end].equals(""));
        StringBuilder sb = new StringBuilder();
        for (int i = end; i >= 0; i--){
            if (!list[i].equals("")) {
                if (i != end) sb.append(" ");
                sb.append(list[i]);
            }
        }
        return sb.toString();
    }
}