// https://leetcode.com/problems/car-fleet-ii

class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        int len = cars.length; //pos, speed

        double[] res = new double[len];
        Arrays.fill(res, -1);


/*
https://www.youtube.com/watch?v=iGxc4hgBM4c&t=0s

x x x x x x  [ a b c x x ]
         cur |-> stack <-|

while(st.peek().speed >= cur) : means never collide ... do pop

if(the rightCar speed slower than cur) :
1. check if collideTime<res[rightCar] || res[rightCar]<0
       res[i] = collideTime
   else 
       -> means never collide ... do pop

*/
        Stack<Integer> st = new Stack<>();
        for(int i=len-1; i>=0; i--){

            int[] cur = cars[i];
            int pos = cur[0];
            int spd = cur[1];

            while (!st.isEmpty() && cars[st.peek()][1] >= spd ) {
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