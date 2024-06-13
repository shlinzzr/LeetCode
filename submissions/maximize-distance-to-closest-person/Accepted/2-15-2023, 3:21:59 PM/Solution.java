// https://leetcode.com/problems/maximize-distance-to-closest-person

class Solution {
    public int maxDistToClosest(int[] seats) {
        
       int distance = 0, n = seats.length, last = -1;
        
        for (int i = 0; i < n; ++i) {
            if (seats[i] == 1) {
                distance = last == -1 ? i : Math.max(distance, (i - last) / 2);
                last = i;
            }
        }
        distance = Math.max(distance, n - last - 1);
        return distance;
        
        
        
    }
}