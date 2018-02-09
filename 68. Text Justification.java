class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new ArrayList<>();
        int n = words.length;
        int[] len = new int[n+1];
        len[0] = 0;
        for (int i = 1; i <= n; i++){
            len[i] = len[i-1] + words[i-1].length();
        }
            
        int start = 0, end = 0;
        while(start <= n && end <= n){
            while(++end <= n && (len[end]-len[start]+end-start-1 <= maxWidth));
            --end;
            StringBuilder sb = new StringBuilder();
            int remain = maxWidth - (len[end]-len[start]);
            int base = end-start-1 == 0 ? remain : remain / (end-start-1);
            int sum = end-start-1 == 0 ? 0 : remain % (end-start-1);
            int cnt = 0;
            if (end == n){
                base = remain == 0 ? 0 : 1; //[""] 0 
                sum = 0;
            }
            //System.out.println(len[end] + ";" + len[start]);
            System.out.println(start + ";" + end + ";" + remain + ";" + base + ";" + sum);
            for (int i = start; i < end; i++){
                sb.append(words[i]);
                if(i < end-1 || start == end - 1){
                    int blankCnt = base + (cnt++ < sum ? 1 : 0);
                    for (int j = 0; j < blankCnt; j++)
                        sb.append(" ");
                }
                
            }
            if(end == n){
                for (int j = sb.length(); j < maxWidth; j++)
                    sb.append(" ");
            }
            ret.add(sb.toString());
            start = end;
            if(end == n) break;
        }
        return ret;
    }
}