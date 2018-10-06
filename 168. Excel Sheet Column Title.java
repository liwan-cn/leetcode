class Solution {
    public String convertToTitle(int n) {
        StringBuffer strB = new StringBuffer();
        while(n > 0){
            if(n % 26 == 0)
                strB.append((char)('Z'));
            else
                strB.append((char)('A' + n % 26 -1));
            n--;
            n /= 26;
        }
        return strB.reverse().toString();
    }
}