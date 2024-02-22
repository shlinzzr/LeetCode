// https://leetcode.com/problems/car-fleet

class Solution {
    public int carFleet(int target, int[] pos, int[] speed) {
        int len = speed.length;
       
        Map<Integer, Double> m = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < pos.length; ++i)
            m.put(pos[i], (double)(target - pos[i]) / speed[i]); // position, costTime
        
        
        int res = 0; double cur = 0;
        for (double time : m.values()) { // position 從大到小
            if (time > cur) {
                cur = time;
                res++;
            }
        }
        return res;
            
        
    }
}