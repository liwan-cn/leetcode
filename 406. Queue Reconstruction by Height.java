class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0)
            return new int[0][0];
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < people.length; i++)
            list.add(people[i][1], new int[]{people[i][0], people[i][1]});
        int[][] res = new int[people.length][2];
        for (int i = 0, l = list.size(); i < l; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}