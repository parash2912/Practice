class Solution {
    public int arrangeCoins(int n) {
        int coinStair = 1;
        while(coinStair <= n) {
            n -= coinStair;
            coinStair++;
        }
        return coinStair - 1;
    }
}
