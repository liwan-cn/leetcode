class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }
    public void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int target, int start){
        if(target < 0) return;
        if(target == 0) list.add(new ArrayList<>(tempList));
        else{ 
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, target - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}