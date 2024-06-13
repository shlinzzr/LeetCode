// https://leetcode.com/problems/ipo

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[] earn = new int[n];
        

        PriorityQueue<int[]> task = new PriorityQueue<>( // idx, earn, capital
            (a, b) -> a[2]-b[2]
        );
        for(int i=0; i<n; i++){
            task.offer(new int[]{i, profits[i], capital[i]});
        }


        PriorityQueue<int[]> pool = new PriorityQueue<>( //  idx, earn, captial
            (a,b)-> b[1]-a[1]
        );

        
        while(k-->0){
            
            while(!task.isEmpty() && task.peek()[2]<=w){
                pool.offer(task.poll());
            }

            if(pool.isEmpty())
                return w;

            else {
                w += pool.poll()[1];
            }
        }

        return w;


    }


}