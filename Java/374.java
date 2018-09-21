/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        if(n <= 0) {
            return 1;
        }
        int prev_smaller = 0;
        int prev_greater = n;
        int g = -1;
        while((g = guess(n)) != 0) {
            int temp = n;
            if(g == -1) {
                n = prev_smaller + (n - prev_smaller)/2;
                prev_greater = temp;
            } else {
                if(n == prev_greater) {
                    return n;
                }
                n = n + (prev_greater - n)/2;
                prev_smaller = temp;
            }
        }
        return n;
    }
}
