class Solution {
    private int b_search(int[] nums, int target, int start, int end) {
        if((start > end) || (start == end && nums[start] != target)) {
            return -1;
        }
        
        int mid = (start + end)/2;
        if(nums[mid] == target) {
            return mid;
        }
        if(nums[mid] < target) {
            return b_search(nums, target, mid + 1, end);
        }
        return b_search(nums, target, start, mid - 1);
    }
    public int search(int[] nums, int target) {
        return b_search(nums, target, 0, nums.length - 1);
    }
}
