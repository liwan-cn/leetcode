class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int key : count.keySet()){
            int cnt = count.get(key);
            if (bucket[cnt] == null){
                bucket[cnt] = new ArrayList<>();
            }
            bucket[cnt].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length; i > 0; i--){
            if (bucket[i] != null){
                for (int key : bucket[i]){
                    if (k > 0) res.add(key);
                    else return res;
                    k--;
                }
                //System.out.println(res.toString());
            }
        }
        return res;
    }
}