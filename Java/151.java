public class Solution {
    public String reverseWords(String s) {
        String[] spl_str = s.trim().split("\\s+");
        StringBuilder builder = new StringBuilder();
        for(int index = spl_str.length - 1; index >= 0; --index) {
            builder.append(spl_str[index].trim());
            if(index != 0) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}
