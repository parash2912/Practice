class Solution {
    public int minSteps(int n) {
        if(n == 1) {
            return 0;
        }
        int numA = 1;
        int count = 1;
        int clip = 1;
        while(numA != n) {
            if(n % numA == 0 && count != 1) {
                count++;
                clip = numA;
            }
            numA += clip;
            count++;
        }
        return count;
    }
}
