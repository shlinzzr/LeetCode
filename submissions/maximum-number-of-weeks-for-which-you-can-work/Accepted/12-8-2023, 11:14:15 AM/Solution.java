// https://leetcode.com/problems/maximum-number-of-weeks-for-which-you-can-work

class Solution {
    public long numberOfWeeks(int[] milestones) {

        int len = milestones.length;
        long sum=0;
        long max = 0;
        for(int i=0; i<len; i++){
            
            sum+= milestones[i];
            max = Math.max(max, milestones[i]);
        }
        
        //|<-------- total ------------------>
        //xxxxxxxxxxxxxxxxxxxxxxxxxooooaaxxbbb
        //|--------> max < ------ |<-others->|

        if(max<=sum/2)
            return sum;
        
        long others= sum-max;
        return 2*others+1;
        


        // pq : TLE
        // PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
        //     (a,b) -> (b.getValue()-a.getValue())
        // );

        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int i=0; i<milestones.length; i++){
        //     map.put(i, milestones[i]);
        // }        

        // pq.addAll(map.entrySet());

        // Queue<Map.Entry<Integer, Integer>> q = new LinkedList<>();

        // long res= 0 ;

        // while(!pq.isEmpty()){

        //     Map.Entry<Integer, Integer> en = pq.poll();
        //     en.setValue(en.getValue()-1);
        //     q.offer(en);
        //     res++;
        //     if(q.size()<2)
        //         continue;

        //     Map.Entry<Integer, Integer> p = q.poll();
        //     if(p.getValue()>0){
        //         pq.offer(p);
        //     }
        // }

        // return res;
    }
}