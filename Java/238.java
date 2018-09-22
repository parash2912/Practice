class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int prod_nz = 1;
        int zero_count = 0;
        for(int num : nums) {
            prod *= num;
            if(num != 0) {
                prod_nz *= num;
            } else {
                zero_count++;
            }
        }
        int[] ret = new int[nums.length];
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] != 0) {
                ret[i] = prod / nums[i];
            } else {
                ret[i] = zero_count > 1 ? 0 : prod_nz;
            }
        }
        return ret;
    }
}
