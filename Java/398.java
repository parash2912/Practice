class Solution {
    private Map<Integer, ArrayList<Integer>> indices = new HashMap<Integer, ArrayList<Integer>>();
    public Solution(int[] nums) {
        for(int i = 0; i < nums.length; ++i) {
            ArrayList<Integer> index_list;
            if(indices.containsKey(nums[i])) {
                index_list = indices.get(nums[i]);
            } else{
                index_list = new ArrayList<Integer>();   
            }
            index_list.add(i);
            indices.put(nums[i], index_list);
        }
    }
    
    public int pick(int target) {
        Random r_num = new Random();
        ArrayList<Integer> ind_list = indices.get(target);
        return ind_list.get(r_num.nextInt(ind_list.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
