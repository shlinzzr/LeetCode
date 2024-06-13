// https://leetcode.com/problems/maximum-sum-obtained-of-any-permutation

class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int M = (int) 1e9+7;

        Arrays.sort(nums);

        TreeMap<Integer, Integer> cntMap = new TreeMap<>();
        for(int[] r : requests){
            cntMap.put(r[0], cntMap.getOrDefault(r[0], 0)+1);
            cntMap.put(r[1]+1, cntMap.getOrDefault(r[1]+1, 0)-1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>( //  agg, wisth
            (a,b)-> b[0] - a[0]
        );


        int agg = 0;
        int prev = -1;
        TreeMap<Integer, Integer> aggMap = new TreeMap<>();
        for(int x: cntMap.keySet()){

            if(prev!=-1){
                int width = x-prev;
                pq.offer(new int[]{agg, width});
            }
            agg += cntMap.get(x);
            // System.out.println("x=" + x +  " agg=" + agg);
            aggMap.put(x, agg);
            prev = x;
        }

        Arrays.sort(nums);
        int[] presum = new int[nums.length+1];
        for(int i=0; i<nums.length; i++){
            presum[i+1] =  nums[i] + presum[i];
        }


        // 0 1 2 3 4 
        //   |   |
        // | |
        //.4 5 3 2 1

        // 10 + 4 + 3 +2

        long res = 0;
        for(int i=nums.length; i>0 && !pq.isEmpty(); i--){
            int[] p = pq.poll();
            int a = p[0];
            int width = p[1];
            
            int sum = presum[i]-presum[i-width];
            // System.out.println(a + " " + width+ " " + sum);
            i= i-width+1;
            res = (res + sum*a)%M;

        }

        return (int) res;


       


    }
}