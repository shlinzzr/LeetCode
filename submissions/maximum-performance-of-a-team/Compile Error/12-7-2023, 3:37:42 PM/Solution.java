// https://leetcode.com/problems/maximum-performance-of-a-team

class Solution {

    class Engineer {
        int sp;
        int ef;
        int idx;
        public Engineer(int idx, int sp, int ef){
            this.idx = idx;
            this.sp = sp;
            this.ef = ef;
        }
    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {    

        Engineer[] arr = new Engineer[n];
        for(int i=0; i<n; i++){
            arr[i] = new Engineer(i, speed[i], efficiency[i]);
        }

        Arrays.sort(arr, (a,b)-> b.ef-a.ef); // arr sort by efficiency desc

        PriorityQueue<Engineer> pq = new PriorityQueue<>( // pq sort by speed asc
            (a,b) -> a.sp - b.sp
        );

        // keep the best performance in the pq, ef:from high to low 
        // so every time we multiply the current Engineer's efficiency
        // and  :pop the minimum speed enginner

        int M = (int) 1e9+7;

        long speedSum = 0,  max=0;
        for(int i=0; i<n; i++){
            
            pq.offer(arr[i]);
            speedSum += arr[i].sp;

            max = Math.max(max, arr[i].ef*sum);

            if(pq.size()==k){
                sum-=pq.poll().sp;
            }
        }

        return (int) (max%M);
    
    }
}