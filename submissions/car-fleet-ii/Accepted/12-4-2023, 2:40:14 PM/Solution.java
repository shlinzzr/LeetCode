// https://leetcode.com/problems/car-fleet-ii

class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        int len = cars.length; //pos, speed


        double[] res = new double[len];
        Arrays.fill(res, -1);

        Stack<Integer> st = new Stack<>();
        // Deque<int[]> dq = new ArrayDeque<>();
        for(int i=len-1; i>=0; i--){

            int[] cur = cars[i];
            int pos = cur[0];
            int spd = cur[1];

            while (!st.isEmpty() && spd <= cars[st.peek()][1]) {
                st.pop();
            }

            while (!st.isEmpty()) {
                int rightCar = st.peek();
                double collideTime = 1.0 * (cars[rightCar][0] - pos) / (spd - cars[rightCar][1]);
                if (collideTime <= res[rightCar] || res[rightCar] < 0) {
                    res[i] = collideTime;
                    break;
                }
                // This car will collide with cars after candidate.
                st.pop();
            }
             st.push(i);

        }
        
        return res;

    }
}