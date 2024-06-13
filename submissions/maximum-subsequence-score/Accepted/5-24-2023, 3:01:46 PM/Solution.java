// https://leetcode.com/problems/maximum-subsequence-score

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        
        int len = nums1.length;
        int[][] arr = new int[len][2];
        
        for (int i = 0; i < len; ++i)
            arr[i] = new int[] {nums2[i], nums1[i]};
        
        Arrays.sort(arr, (a, b) -> b[0] - a[0]); //sort by num2 大到小
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //小的先pop
        
        long max = 0, sum = 0;
        for (int[] a : arr) {
            
            int min = a[0];
            
            pq.add(a[1]); //把nums1丟到pq;
            sum += a[1];
            if (pq.size() > k) 
                sum -= pq.poll();
            
            if (pq.size() == k)
                max = Math.max(max, (sum * min));
        }
        return max;
        
        
        
        
//         PriorityQueue<int[]> pq = new PriorityQueue<>(
//             (a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]
        
//         );
        
//            int len = nums1.length;
        
        
//         int sum = 0;
        
//         for(int i=0; i<len; i++){
            
//             sum+=nums1[i];
            
//             pq.offer(new int[]{nums2[i], nums1[i]});

//               if(pq.size()>k){
//                   int[] p = pq.poll();
//                   sum-= p[1];
                  
//               }
            
            
            
//             if(pq.size()==k && i!=len-1){
//                 int[] p = pq.poll();
//                 sum-=p[1];
                
//             }
            
            
//         }
        
        
//         int coef = Integer.MAX_VALUE;
        
//         for(int[] p : pq){
            
//             coef = Math.min(p[0], coef);
//         }

        
//         return sum*coef;
        
        
        
        
        
        
//         long[] dp = new long[k+1];
//         int coef = 1;
//         long total = 0;
        
//      
        
//         for(int i=1; i<len ; i++){
            
//             long val = (total + nums1[i]) * Math.min(coef, nums2[i]);
            
//             if(val>dp[i-1]){
//                 System.out.println("chose " + i);
//                 total+= nums1[i];
//                 coef = Math.min(coef, nums2[i]);
//             }
            
//             dp[i] = Math.max(dp[i-1], val);
            
//         }
        
//         return dp[k];
        
        
        
    }
}