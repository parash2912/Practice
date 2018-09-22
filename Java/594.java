class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for(int num : nums) {
            if(freq.containsKey(num)) {
                freq.put(num, freq.get(num) + 1);
            } else {
                freq.put(num, 1);
            }
        }
        
        int max_count = 0;
        for(int key : freq.keySet()) {
            // This condition is not required as map puts integers in sorted order, but cannot assume as the API does not guarantee that.
            if(freq.containsKey(key - 1)) {
                int l_count = freq.get(key) + freq.get(key - 1);
                if(l_count > max_count) {
                   max_count = l_count; 
                }
            }
            if(freq.containsKey(key + 1)) {
                int r_count = freq.get(key) + freq.get(key + 1);
                if(r_count > max_count) {
                   max_count = r_count; 
                } 
            }
        }
        return max_count;
    }
}
