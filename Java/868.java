class Solution {
    public int binaryGap(int N) {
        int max_count = 0;
        while(N != 0) {
            if((N & 1) == 1) {
                int count = 1;
                N >>>= 1;
                while((N & 1) != 1) {
                    N >>>= 1;
                    count++;
                    if(N == 0) {
                        return max_count;
                    }
                }
                if(count > max_count) {
                    max_count = count;
                }
            } else {
                N >>>= 1;
            }
        }
        return max_count;
    }
}
