class Solution {
    public int calPoints(String[] ops) {
        List<Integer> score = new ArrayList<>();
        for (String s: ops){
            if (s.equals("+")) 
                score.add(score.get(score.size()-1) + score.get(score.size()-2));
            else if(s.equals("D")) 
                score.add(score.get(score.size()-1) * 2);
            else if(s.equals("C")) 
                score.remove(score.size()-1);
            else 
                score.add(Integer.valueOf(s));
        }
        int ret = 0;
        for (Integer s: score)
            ret += s;
        return ret;
    }
}