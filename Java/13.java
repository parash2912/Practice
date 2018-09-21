class Solution {
    Map<Character, Integer> romanIntMap = new HashMap<Character, Integer>();
    public int romanToInt(String s) {
        if(romanIntMap.size() == 0) {
            romanIntMap.put('I', 1);
            romanIntMap.put('V', 5);
            romanIntMap.put('X', 10);
            romanIntMap.put('L', 50);
            romanIntMap.put('C', 100);
            romanIntMap.put('D', 500);
            romanIntMap.put('M', 1000);
        }
        
        if(s.length() == 0) {
            return 0;
        }
        
        if(s.length() == 1) {
            return romanIntMap.get(s.charAt(0));
        }
        
        int result = 0;
        for(int i = 0; i < s.length() - 1; ++i) {
            int curr = romanIntMap.get(s.charAt(i));
            int next = romanIntMap.get(s.charAt(i+1));
            if(curr < next) {
                result -= curr;
            } else {
                result += curr;
            }
        }
        result += romanIntMap.get(s.charAt(s.length() - 1));
        return result;
    }
}
