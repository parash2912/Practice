class Solution {
    private Set<ArrayList<Integer>> combSumHelper(int[] cand, int target, int index) {
        Set<ArrayList<Integer>> ret = new HashSet<ArrayList<Integer>>();
        if(index >= cand.length) {
            return ret;
        }
        if(cand[index] == target) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(cand[index]);
            ret.add(temp);
        }
        if(cand[index] < target) {
            Set<ArrayList<Integer>> temp = combSumHelper(cand, target - cand[index], index);
            for(ArrayList<Integer> arr : temp) {
                arr.add(cand[index]);
                Collections.sort(arr);
                ret.add(arr);
            }    
        }
        
        Set<ArrayList<Integer>> temp2 = combSumHelper(cand, target, index + 1);
        for(ArrayList<Integer> arr : temp2) {
            Collections.sort(arr);
            ret.add(arr);
        }
        return ret;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>(combSumHelper(candidates, target, 0));
        return ret;
    }
}
