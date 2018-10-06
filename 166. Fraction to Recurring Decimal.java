class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        Map<Long, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        long numer = (long) numerator, denomin = (long) denominator;
        if ((numer < 0 && denomin > 0) || (numer > 0 && denomin < 0)){
            res.append("-");
        }
        numer = Math.abs(numer);
        denomin = Math.abs(denomin);
        res.append(String.valueOf(numer / denomin));
        long rem = numer % denomin;
        if (rem != 0) res.append(".");
        int i = res.length();
        while(rem != 0){
            if (map.containsKey(rem)){
                res.insert(map.get(rem), "(");
                res.append(")");
                break;
            }
            map.put(rem, i++);
            res.append(String.valueOf(rem * 10 / denomin));
            rem = rem * 10 % denomin;
        }
        //System.out.println(res);
        return res.toString();
    
    }
}