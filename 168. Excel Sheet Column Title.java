class Solution {
    public String convertToTitle(int n) {
        StringBuffer res = new StringBuffer();
        while(n > 0){
            if(n % 26 == 0)
                res.append((char)('Z'));
            else
                res.append((char)('A' + n % 26 -1));
            n--; n /= 26;
        }
        return res.reverse().toString();
    }
}