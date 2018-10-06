class Solution {
    public String getHint(String secret, String guess) {
        int []s = new int[10];
        int []g = new int[10];
        int A = 0, B = 0;
        for (int i = 0, len = secret.length(); i < len; i++){
            if (secret.charAt(i) == guess.charAt(i)) A ++;
            else {s[secret.charAt(i)-'0'] ++; g[guess.charAt(i)-'0']++;}
        }
        for (int i = 0; i < 10; i++){
            B += Math.min(s[i], g[i]);
        }
        return A+"A"+B+"B";
     }
}