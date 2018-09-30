class Solution {
    public String countAndSay(int n) {
        String str="1";
        int num = 1;
        while(num != n) {
            String s_temp = "";
            char[] str_arr = str.toCharArray();
            for(int i = 0; i < str_arr.length; ++i) {
                int count = 1;
                while(i + 1 < str_arr.length && str_arr[i+1] == str_arr[i]) {
                    i++;
                    count++;
                }
                s_temp += ""+count+""+str_arr[i];
            }
            str = s_temp;
            num++;
        }
        return str;
    }
}
