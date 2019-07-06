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
            //单词长度加上空格长度
            while(++end <= n && (len[end]-len[start]+end-start-1 <= maxWidth));
            --end;
            StringBuilder sb = new StringBuilder();
            int remain = maxWidth - (len[end]-len[start]);
            //base 为初始间隔 sum 为前多少个间隔需要加1 cnt为计数器
            int base = end-start-1 == 0 ? remain : remain / (end-start-1);
            int sum = end-start-1 == 0 ? 0 : remain % (end-start-1);
            int cnt = 0;
            if (end == n){
                //最后一行的特殊处理 间隔为1
                base = remain == 0 ? 0 : 1;
                sum = 0;
            }
            //System.out.println(start + ";" + end + ";" + remain + ";" + base + ";" + sum);
            for (int i = start; i < end; i++){
                sb.append(words[i]);
                if(i < end-1 || start == end - 1){
                    //初始间隔与计数器
                    int blankCnt = base + (cnt++ < sum ? 1 : 0);
                    for (int j = 0; j < blankCnt; j++)
                        sb.append(" ");
                }

            }
            if(end == n){
                //最后一行补全空格
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