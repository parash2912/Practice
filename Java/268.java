class Solution {
    public int missingNumber(int[] nums) {
        int ExpectedSum = nums.length*(nums.length + 1)/2;
        int ActSum = 0;
        for(int num : nums) {
            ActSum += num;
        }
        return ExpectedSum - ActSum;
    }
}
