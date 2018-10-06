class Solution {
    public boolean isVowels(char c){
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0, j = sb.length() - 1;
        while(i <= j){
            while(!isVowels(sb.charAt(i)) && i < j) 
                i++;
            while(!isVowels(sb.charAt(j)) && i < j) 
                j--;
            if(i < j){
                char tmp = sb.charAt(i);
                sb.setCharAt(i,sb.charAt(j)); 
                sb.setCharAt(j,tmp);
            }
            i++;j--;
        }
        return sb.toString();
    }
}