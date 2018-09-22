class Solution {
    public String toLowerCase(String str) {
        StringBuilder retStr = new StringBuilder();
        for(int index = 0; index < str.length(); ++index) {
            char c = str.charAt(index);
            if(c >= 65 && c <=90) {
                retStr.append((char)(str.charAt(index) + 32));
            } else {
                retStr.append(str.charAt(index));
            }
        }
        return retStr.toString();
    }
}
