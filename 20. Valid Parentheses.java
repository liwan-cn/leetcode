class Solution {
    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        int len = str.length();
        for(int i = 0; i < len; i++){
            if(str.charAt(i) == '{'){
                s.push('}');
            }else if(str.charAt(i) == '['){
                s.push(']');
            }else if(str.charAt(i) == '('){
                s.push(')');
            }else if(!s.empty() && str.charAt(i) == s.peek()){
                s.pop();
            }else{
                return false;
            }
        }
        return s.empty();
    }
}