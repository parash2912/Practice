class Solution {
    Map<Long, Integer> memo = new HashMap<Long, Integer>();
    private int intRep(long n) {
        if(n == 1) {
            return 0;
        }
        if(memo.containsKey(n)) {
            return memo.get(n);
        }
        
        if(n % 2 == 0) {
            int num_rep = intRep(n/2) + 1;
            memo.put(n, num_rep);
            return num_rep;
        }
        int num_rep = Math.min(intRep(n-1), intRep(n+1)) + 1;
        memo.put(n, num_rep);
        return num_rep;
    }
    public int integerReplacement(int n) {
        return intRep(n);
    }
}
