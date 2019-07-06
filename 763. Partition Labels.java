class Solution {
    public List<Integer> partitionLabels(String S) {
        int [][] range= new int[26][2];
        for (int i = 0; i < 26; i++)
            range[i] = new int[]{S.length()-1, 0};
        for (int i = 0, l = S.length(); i < l; i++){
            char c = S.charAt(i);
            range[c-'a'][0] = Math.min(range[c-'a'][0], i);
            range[c-'a'][1] = Math.max(range[c-'a'][1], i);
        }
        Arrays.sort(range, (r1, r2) -> (r1[0] - r2[0]));
        int pre = -1, max = range[0][1];
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 26; i++){
            if (range[i][0] > range[i][1]) continue;
            if (range[i][0] > max){
                res.add(max - pre);
                pre = max;

            }
            max = Math.max(max, range[i][1]);
        }
        res.add(max - pre);
        return res;
    }
}