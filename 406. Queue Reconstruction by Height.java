class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0)
            return new int[0][0];
        Arrays.sort(people, (a, b) -> {
                if (b[0] == a[0]) return a[1] - b[1];
                return b[0] - a[0];
        });
        ArrayList<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < people.length; i++)
            tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});

        int[][] res = new int[people.length][];
        for (int i = 0, l = tmp.size(); i < l; i++){
            res[i] = tmp.get(i);
        }
//         int i = 0;
//         for (int[] k : tmp) {
//             res[i][0] = k[0];
//             res[i++][1] = k[1];
//         }
        
        return res;
    }
}