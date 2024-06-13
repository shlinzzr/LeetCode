// https://leetcode.com/problems/minimum-cost-to-hire-k-workers

class Solution {

    public class Worker{
        int q;
        int w;
        double ratio;

        public Worker(int q, int w){
            this.q = q;
            this.w = w;
            this.ratio = this.w*1.0/this.q;
        }
    }


    public double mincostToHireWorkers(int[] q, int[] w, int k) {
        ArrayList<Worker> arr = new ArrayList<>();

        int n = q.length;
        for(int i=0; i<n; i++){
            arr.add(new Worker(q[i],w[i]));
        }

        Collections.sort(arr,(a,b)->Double.compare(a.ratio,b.ratio));

        PriorityQueue<Worker> pq = new PriorityQueue<>((a,b)->(b.q-a.q));

        double ans = Double.MAX_VALUE;
        double sum = 0;

        for(var a : arr){
            pq.add(a);
            sum+=a.q;

            if(pq.size()==k){
                ans = Math.min(ans,sum*a.ratio);
                sum = sum - pq.remove().q;
            }
        }

        return ans;
    }
}