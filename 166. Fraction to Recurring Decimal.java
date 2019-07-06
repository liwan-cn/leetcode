class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        Map<Long, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        long numer = (long) numerator, denomin = (long) denominator;
        if (numer * denomin < 0) res.append("-");
        numer = Math.abs(numer);
        denomin = Math.abs(denomin);
        res.append(numer / denomin);
        long rem = numer % denomin;
        if (rem != 0) res.append(".");
        while (rem != 0) {
            if (map.containsKey(rem)) {
                res.insert(map.get(rem), "(");
                res.append(")");
                break;
            }
            map.put(rem, res.length());
            res.append(rem * 10 / denomin);
            rem = rem * 10 % denomin;
        }
        return res.toString();
    }
}