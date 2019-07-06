class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0, len = s.length(); i < len; i++){
            if(s.charAt(i) == '{'){
                stack.push('}');
            } else if(s.charAt(i) == '['){
                stack.push(']');
            } else if(s.charAt(i) == '('){
                stack.push(')');
            } else if(!stack.empty() && s.charAt(i) == stack.peek()){
                stack.pop();
            } else{
                return false;
            }
        }
        return stack.empty();
    }
}