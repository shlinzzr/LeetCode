// https://leetcode.com/problems/maximum-number-of-robots-within-budget

class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int len = chargeTimes.length;


        int st = 0, ed=len;

        while(st<ed){
            int win = st+(ed-st)/2;

        
            if(slidingWindowMaximum(chargeTimes, runningCosts, win, budget)){
                st = win;
                
            }else{
                ed = win-1;
            }
        }

        return st;

    }

    private boolean slidingWindowMaximum(int[] chargeTimes, int[] runningCosts, int win, long budget){

        int len = chargeTimes.length;

        long res = 0L;
        long sum = 0L;
        Deque<Integer> dq = new ArrayDeque<>(); // chargeTimes

        for(int i=0; i<len; i++){
            sum += runningCosts[i];

            while(!dq.isEmpty() && chargeTimes[dq.peekLast()]<= chargeTimes[i]){
                dq.pollLast();
            }

            dq.offer(i);
            
            while(!dq.isEmpty() && i-win+1 > dq.peek()){
                dq.poll();
            }

            if(i-win+1>=0){
                long ret = chargeTimes[dq.peek()] + (long)win*sum;
                if(ret<=budget) return true;
                sum -= runningCosts[i-win+1];
            }
        }

        return false;



    }
}