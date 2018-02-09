class Solution {
    public boolean isNumber(String s) {
        List<Map<Character, Integer>> stateTrans = new ArrayList<>();
        stateTrans.add(new HashMap<Character, Integer>());
        stateTrans.add(new HashMap<Character, Integer>(){//1
            { put('b', 1); put('s', 2); put('d', 3); put('.', 4); }
        });
        stateTrans.add(new HashMap<Character, Integer>(){//2
            { put('d', 3); put('.',4); }
        }); 
        stateTrans.add(new HashMap<Character, Integer>(){//3
            { put('d', 3); put('.', 5); put('e', 6); put('b', 9); }
        });
        stateTrans.add(new HashMap<Character, Integer>(){//4
            { put('d', 5); }
        });
        stateTrans.add(new HashMap<Character, Integer>(){//5
            { put('d', 5); put('e', 6); put('b', 9); }
        });
        stateTrans.add(new HashMap<Character, Integer>(){//6
            { put('s', 7); put('d', 8); }
        });
                
        stateTrans.add(new HashMap<Character, Integer>(){//7
            { put('d', 8); }
        });
                
        stateTrans.add(new HashMap<Character, Integer>(){//8
            { put('d', 8); put('b', 9); } 
        });

        stateTrans.add(new HashMap<Character, Integer>(){
            { put('b', 9); }//9
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
        /*
        int state = 1;
        char[] ca = s.toCharArray();
        for (char c : ca){
            switch(state){
                case 1:
                    if (c == ' ') state = 1;
                    else if (c == '+' || c == '-') state = 2;
                    else if (c >= '0' && c <= '9') state = 3;
                    else if (c == '.') state = 4;
                    else return false;
                    break;
                case 2:
                    if (c >= '0' && c <= '9') state = 3;
                    else if (c == '.') state = 4;
                    else return false;
                    break;
                case 3:
                    if (c >= '0' && c <= '9') state = 3;
                    else if (c == '.') state = 5;
                    else if (c == 'e') state = 6;
                    else if (c == ' ') state = 9;
                    else return false;
                    break;
                case 4:
                    if (c >= '0' && c <= '9') state = 5;
                    else return false;
                    break;
                case 5:
                    if (c >= '0' && c <= '9') state = 5;
                    else if (c == 'e') state = 6;
                    else if (c == ' ') state = 9;
                    else return false;
                    break;
                case 6:
                    if (c == '+' || c == '-') state = 7;
                    else if (c >= '0' && c <= '9') state = 8;
                    else return false;
                    break;
                case 7:
                    if (c >= '0' && c <= '9') state = 8;
                    else return false;
                    break;
                case 8:
                    if (c >= '0' && c <= '9') state = 8;
                    else if (c == ' ') state = 9;
                    else return false;
                    break;
                case 9:
                    if (c == ' ') state = 9;
                    else return false;
                    break;
                default:
                    return false;
            }
        }
        return (state ==3 || state ==5 || state ==8 || state ==9);
        */
    }
}