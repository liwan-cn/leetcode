class Solution {
    public boolean isNumber(String s) {
        List<Map<Character, Integer>> stateTrans = new ArrayList<>();
        stateTrans.add(new HashMap<Character, Integer>());
        stateTrans.add(new HashMap<Character, Integer>(){
            //1 前导空格可接受状态 空格 符号 数字 小数点
            { put('b', 1); put('s', 2); put('d', 3); put('.', 4); }
        });
        stateTrans.add(new HashMap<Character, Integer>(){
            //2 符号可接受状态 数字 小数点
            { put('d', 3); put('.', 4); }
        });
        stateTrans.add(new HashMap<Character, Integer>(){
            //3 数字可接受状态 数字 小数点 e 空格
            { put('d', 3); put('.', 5); put('e', 6); put('b', 9); }
        });
        stateTrans.add(new HashMap<Character, Integer>(){
            //4 小数点(小数点前无数字)可接受状态 数字
            { put('d', 5); }
        });
        stateTrans.add(new HashMap<Character, Integer>(){
            //5 小数点(小数点前有数字)可接受状态 数字 e 空格
            { put('d', 5); put('e', 6); put('b', 9); }
        });
        stateTrans.add(new HashMap<Character, Integer>(){
            //6 e可接受状态 符号 数字
            { put('s', 7); put('d', 8); }
        });

        stateTrans.add(new HashMap<Character, Integer>(){
            //7 e之后的符号可接受状态 数字
            { put('d', 8); }
        });

        stateTrans.add(new HashMap<Character, Integer>(){
            //8 e之后的数字可接受状态 数字 空格
            { put('d', 8); put('b', 9); }
        });

        stateTrans.add(new HashMap<Character, Integer>(){
            //9 末尾空格可接受状态 空格
            { put('b', 9); }
        });

        int state = 1;
        char[] ca = s.toCharArray();
        for (char c : ca){
            Character ac;
            if(c == ' ') ac = 'b';
            else if (c == '+' || c == '-')  ac = 's';
            else if (c >= '0' && c <= '9')  ac = 'd';
            else if (c == '.')  ac = '.';
            else if (c == 'e') ac = 'e';
            else return false;
            state = stateTrans.get(state).getOrDefault(ac, 0);
            if (state == 0) return false;
        }
        return (state ==3 || state ==5 || state ==8 || state ==9);
    }
}