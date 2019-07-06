class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (int i = 0; i < moves.length(); i++){
            if(moves.charAt(i) == 'U') x++;
            else if (moves.charAt(i) == 'D') x--;
            else if (moves.charAt(i) == 'L') y++;
            else if (moves.charAt(i) == 'R') y--;
        }
        return (x == 0) && (y == 0);
    }
}