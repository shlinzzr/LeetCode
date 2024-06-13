// https://leetcode.com/problems/maximum-subsequence-score

class Solution {
    
    class Tuple{
        int v1;
        int v2; 
        public Tuple(int v1, int v2){
            this.v1=v1;
            this.v2=v2;
        }
    }


    public long maxScore(int[] nums1, int[] nums2, int k) {
        int len = nums1.length;

        List<Tuple> list = new ArrayList<>();

        for(int i=0; i<len; i++){
            list.add(new Tuple(nums1[i], nums2[i]));
        }

        Collections.sort(list, (a,b)-> b.v2-a.v2);

        PriorityQueue<Tuple> pq = new PriorityQueue<>(
            (a,b) -> a.v1-b.v1
        );
        
        long max = 0;
        long sum = 0;
        for(int i=0; i<len; i++){

            sum+=list.get(i).v1;
            pq.offer(list.get(i));

            if(pq.size()==k){
                max= Math.max(max, sum*list.get(i).v2);
                sum-=pq.poll().v1;
            }
        }

        return max;
        
        
    }
}