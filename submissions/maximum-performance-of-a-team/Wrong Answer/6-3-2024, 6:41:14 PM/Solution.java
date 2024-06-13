// https://leetcode.com/problems/maximum-performance-of-a-team

class Solution {

    class Engineer{
        int s;
        int e;

        public Engineer(int s, int e){
            this.s=s;
            this.e=e;
        }
    }


    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {

        List<Engineer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new Engineer(speed[i], efficiency[i]));
        }

        PriorityQueue<Engineer> pq = new PriorityQueue<>(
            (a,b) -> a.s-b.s
        );

        Collections.sort(list, (a,b)-> b.e-a.e);
        int sum = 0 ;
        int max = 0;
        for(int i=0; i<n; i++){

            Engineer eng = list.get(i);
            sum += eng.s;

            pq.offer(eng);
            while(pq.size()>k){
                sum-= pq.poll().s;
            }

            max = Math.max(max, sum*eng.e);
        }
        
        return max;
        
    }
}