class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int rad = 0;
        Arrays.sort(heaters);
        for(int house : houses) {
            int min = Integer.MAX_VALUE;
            for(int heater : heaters) {
                int dist = Math.abs(heater - house);
                if(dist < min) {
                    min = dist;
                } else if(dist > min){
                    break;
                }
            }
            if(min > rad) {
                rad = min;
            }
        }
        return rad;
    }
}
