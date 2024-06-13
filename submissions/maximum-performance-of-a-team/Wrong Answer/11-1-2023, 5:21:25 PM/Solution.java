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

        Arrays.sort(arr, (a,b)-> b.ef-a.ef);

        PriorityQueue<Engineer> pq = new PriorityQueue<>(
            (a,b) -> a.sp - b.sp
        );


        int sum = 0,  max=0;
        for(int i=0; i<n; i++){
            pq.offer(arr[i]);
            sum += arr[i].sp;

            max = Math.max(max, arr[i].ef*sum);

            if(pq.size()==k){
                sum-=pq.poll().sp;
            }
        }

        return max;
    
    }
}