class Solution {
    Map<Integer, List<String>> memo = new HashMap<Integer, List<String>>();
    public List<String> generateParenthesis(int n) {
        if(n == 0) {
            List<String> ret = new ArrayList<String>();
            return ret;
        }
        if(n == 1) {
            List<String> ret = new ArrayList<String>();
            ret.add("()");
            return ret;
        }
        if(memo.containsKey(n)) {
            return memo.get(n);
        }
        int x = 1;
        Set<String> ret = new HashSet<String>();
        while(x != n) {
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            for(int i = 0; i < x; ++i) {
                sb2.append("(");
                sb3.append(")");
            }
            List<String> tmp = generateParenthesis(n-x);
            List<String> tmp2 = generateParenthesis(x);
            for(String str : tmp) {
                for(String str1 : tmp2) {
                    ret.add(str+str1);
                    ret.add(str1+str);
                }
                ret.add(sb2.toString()+sb3.toString()+str);
                ret.add(sb2.toString()+str+sb3.toString());
                ret.add(str+sb2.toString()+sb3.toString());
            }
            x++;
        }
        
        List<String> retList = new ArrayList<String>(ret);
        memo.put(n, retList);
        return retList;
    }
}
