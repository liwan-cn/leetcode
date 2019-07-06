class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0, len = input.length(); i < len; i++){
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*'){
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left){
                    for (int r : right){
                        if (c == '+') res.add(l + r);
                        if (c == '-') res.add(l - r);
                        if (c == '*') res.add(l * r);
                    }
                }
            }
        }
        if (res.isEmpty()) res.add(Integer.parseInt(input));
        return res;
    }
}