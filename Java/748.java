class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> l_freq = new HashMap<Character, Integer>();
        for(int i = 0; i < licensePlate.length(); ++i) {
            char ch = Character.toLowerCase(licensePlate.charAt(i));
            if(!Character.isLetter(ch)) {
                continue;
            }
            if(l_freq.containsKey(ch)) {
                l_freq.put(ch, l_freq.get(ch) + 1);
            } else {
                l_freq.put(ch, 1);
            }
        }
        
        String minStr = "";
        for(String word : words) {
            Map<Character, Integer> temp_map = new HashMap<Character, Integer>(l_freq);
            for(int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                if(temp_map.containsKey(ch)) {
                    int freq = temp_map.get(ch);
                    if(freq == 1) {
                        temp_map.remove(ch);
                    } else {
                        temp_map.put(ch, freq - 1);
                    }
                }
            }
            if(temp_map.size() == 0 && (word.length() < minStr.length() || minStr == "")) {
                minStr = word;
            }
        }
        return minStr;
    }
}
