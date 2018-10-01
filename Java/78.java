class Solution {
    private List<List<Integer>> pset(int[] nums, int index) {
        if(index == nums.length) {
            List<List<Integer>> l = new ArrayList<List<Integer>>();
            List<Integer> t = new ArrayList<Integer>();
            l.add(t);
            return l;
        }
        List<List<Integer>> ps = pset(nums, index + 1);
        List<List<Integer>> ps_ret = new ArrayList<List<Integer>>(ps);
        for(List<Integer> l : ps) {
            List<Integer> temp = new ArrayList<Integer>(l);
            temp.add(nums[index]);
            ps_ret.add(temp);
        }
        return ps_ret;
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        return pset(nums, 0);
    }
}
