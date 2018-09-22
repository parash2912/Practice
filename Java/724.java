class Solution {
    public int pivotIndex(int[] nums) {
        Map<Integer, Integer> leftSum = new HashMap<Integer, Integer>();
        int sum = 0;
        for(int index = 0; index < nums.length; ++index) {
            leftSum.put(index, sum);
            sum += nums[index];
        }
        sum = 0;
        int retIndex = -1;
        for(int index = nums.length - 1; index >= 0; --index) {
            if(leftSum.get(index) == sum) {
                retIndex = index;
            }
            sum += nums[index];
        }
        return retIndex;
    }
}
