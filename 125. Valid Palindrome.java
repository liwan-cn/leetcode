class Solution {
    public boolean isPalindrome(String s) {
        int head = 0, tail = s.length() - 1;
        while(head <= tail) {
            char h = s.charAt(head);
            char t = s.charAt(tail);
            if (!Character.isLetterOrDigit(h)) {
                head++;
            } else if(!Character.isLetterOrDigit(t)) {
                tail--;
            } else {
                if (Character.toLowerCase(h) != Character.toLowerCase(t)) {
                    return false;
                }
                head++; tail--;
            }
        }
        return true;
    }
}