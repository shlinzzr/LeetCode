// https://leetcode.com/problems/time-to-cross-a-bridge

class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {
        int ans = 0, free = 0; 
        
        PriorityQueue<int[]> leftWait = new PriorityQueue<>((a, b)->a[0]-b[0]); 
        PriorityQueue<int[]> rightWait = new PriorityQueue<>((a, b)->a[0]-b[0]); 
        PriorityQueue<int[]> leftArrival = new PriorityQueue<>((a, b)->(a[0] != b[0] ? b[0]-a[0] : b[1]-a[1]));
        PriorityQueue<int[]> rightArrival = new PriorityQueue<>((a, b)->(a[0] != b[0] ? b[0]-a[0] : b[1]-a[1])); 
        for (int i = 0; i < time.length; ++i) 
            leftArrival.add(new int[]{time[i][0]+time[i][2], i}); 
        while (n > 0 || rightWait.size() > 0 || rightArrival.size() > 0) {
            if (rightArrival.isEmpty() && (rightWait.isEmpty() || rightWait.peek()[0] > free) && (n == 0 || leftArrival.isEmpty() && (leftWait.isEmpty() || leftWait.peek()[0] > free))) {
                int cand = Integer.MAX_VALUE; 
                if (n > 0 && leftWait.size() > 0) cand = Math.min(cand, leftWait.peek()[0]); 
                if (rightWait.size() > 0) cand = Math.min(cand, rightWait.peek()[0]); 
                free = cand; 
            }
            while (leftWait.size() > 0 && leftWait.peek()[0] <= free) {
                int i = leftWait.poll()[1]; 
                leftArrival.add(new int[] {time[i][0] + time[i][2], i}); 
            }
            while (rightWait.size() > 0 && rightWait.peek()[0] <= free) {
                int i = rightWait.poll()[1]; 
                rightArrival.add(new int[] {time[i][0] + time[i][2], i}); 
            }
            if (rightArrival.size() > 0) {
                int i = rightArrival.poll()[1]; 
                free += time[i][2]; 
                if (n > 0) leftWait.add(new int[] {free+time[i][3], i}); 
                else ans = Math.max(ans, free); 
            } else {
                int i = leftArrival.poll()[1]; 
                free += time[i][0]; 
                rightWait.add(new int[] {free+time[i][1], i}); 
                --n; 
            }
        }
        return ans; 
    }
}