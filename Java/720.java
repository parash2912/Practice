class Solution {
    public String longestWord(String[] words) {
        Set<String> wordset = new HashSet<String>();
        for(String word : words) {
            wordset.add(word);
        }
        String longest = "";
        int longest_length = -1;
        for(String word : words) {
            StringBuilder str = new StringBuilder(word);
            while(str.length() != 0) {
                str.deleteCharAt(str.length() - 1);
                if(!wordset.contains(str.toString())) {
                    break;
                }   
            }
            if(str.length() == 0 && ((word.length() > longest_length) || (word.length() == longest_length && word.compareTo(longest) < 0))) {
                longest_length = word.length();
                longest = word;
            }
        }
        return longest;
    }
}
