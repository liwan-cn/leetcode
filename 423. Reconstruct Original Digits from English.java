class Solution {
    public String originalDigits(String s) {
        int[] digitCnt = new int[10];
        int[] charCnt = new int[26];
        for (int i = 0, l = s.length(); i < l; i++){
            charCnt[s.charAt(i)-'a'] ++;
        }
        digitCnt[0] = charCnt['z'-'a']; 
        charCnt['e'-'a'] -= charCnt['z'-'a']; 
        charCnt['r'-'a'] -= charCnt['z'-'a']; 
        charCnt['o'-'a'] -= charCnt['z'-'a'];
        
        digitCnt[2] = charCnt['w'-'a']; 
        charCnt['t'-'a'] -= charCnt['w'-'a']; 
        charCnt['o'-'a'] -= charCnt['w'-'a']; 
        
        digitCnt[6] = charCnt['x'-'a']; 
        charCnt['s'-'a'] -= charCnt['x'-'a']; 
        charCnt['i'-'a'] -= charCnt['x'-'a'];
        
        digitCnt[8] = charCnt['g'-'a']; 
        charCnt['e'-'a'] -= charCnt['g'-'a']; 
        charCnt['i'-'a'] -= charCnt['g'-'a'];
        charCnt['h'-'a'] -= charCnt['g'-'a']; 
        charCnt['t'-'a'] -= charCnt['g'-'a'];
        
        digitCnt[4] = charCnt['u'-'a']; 
        charCnt['f'-'a'] -= charCnt['u'-'a']; 
        charCnt['o'-'a'] -= charCnt['u'-'a'];
        charCnt['r'-'a'] -= charCnt['u'-'a']; 
        
        digitCnt[5] = charCnt['f'-'a']; 
        charCnt['i'-'a'] -= charCnt['f'-'a']; 
        charCnt['v'-'a'] -= charCnt['f'-'a'];
        charCnt['e'-'a'] -= charCnt['f'-'a']; 
        
        digitCnt[1] = charCnt['o'-'a']; 
        // charCnt['n'-'a'] -= charCnt['o'-'a']; 
        // charCnt['e'-'a'] -= charCnt['o'-'a'];
        digitCnt[3] = charCnt['t'-'a']; 
        digitCnt[7] = charCnt['s'-'a']; 
        digitCnt[9] = charCnt['i'-'a'];
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digitCnt.length; i++){
            for (int j = 0; j < digitCnt[i]; j++){
                sb.append(""+i);
            }
        }
        return sb.toString();

    }
}