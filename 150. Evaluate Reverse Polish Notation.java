class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens){
            if(s.equals("+")) {
                stack.push(op(stack.pop(), stack.pop(), "+"));
            }
            else if(s.equals("/")) {
                stack.push(op(stack.pop(), stack.pop(), "/"));
            }
            else if(s.equals("*")) {
                stack.push(op(stack.pop(), stack.pop(), "*"));
            }
            else if(s.equals("-")) {
                stack.push(op(stack.pop(), stack.pop(), "-"));
            }
            else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
    private int op(int a, int b, String op) {
        switch (op) {
            case "+" : return b + a;
            case "-" : return b - a;
            case "*" : return b * a;
            case "/" : return b / a;
            default : return 0;
        }
    }
}