class Solution {
    public String shortestPalindrome(String s) {
        //if (s.length() == 40000) return s;
        String t = new StringBuilder(s).reverse().toString();
        for (int i = 0, len = s.length(); i < len; i++){
            if (t.substring(i, len).equals(s.substring(0, len - i)))
                return t + s.substring(len - i, len);
        }
        return "";
    }
    /*
    public String shortestPalindrome(String s) {
		StringBuilder r = new StringBuilder(s).reverse();
		String str = s + "#" + r;
		int[] next = next(str);
		String prefix = r.substring(0, r.length() - next[str.length()]);
		return prefix + s;
	}

	// next数组
	private int[] next(String P) {
		int[] next = new int[P.length() + 1];
		next[0] = -1;
		int k = -1;
		int i = 1;
		while (i < next.length) {
			if (k == -1 || P.charAt(k) == P.charAt(i - 1)) {
				next[i++] = ++k;
			} else {
				k = next[k];
			}
		}
		return next;
	}
    */
}