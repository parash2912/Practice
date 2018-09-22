class Solution {
    public int pivotIndex(int[] nums) {
        Map<Integer, Integer> leftSum = new HashMap<Integer, Integer>();
        int sum = 0;
        for(int index = 0; index < nums.length; ++index) {
            leftSum.put(index, sum);
            sum += nums[index];
        }
        for(int index = 0; index < nums.length; ++index) {
            sum -= nums[index];
            if(leftSum.get(index) == sum) {
                return index;
            }
        }
        return -1;
    }
}
