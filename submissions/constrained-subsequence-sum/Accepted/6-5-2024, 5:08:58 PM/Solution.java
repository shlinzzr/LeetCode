// https://leetcode.com/problems/constrained-subsequence-sum

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {

        int len = nums.length;

        Deque<int[]> dq = new ArrayDeque<>(); // idx, val // save recently k sum

        int max = Integer.MIN_VALUE;
        for(int i=0; i<len; i++){
            int cur = nums[i];

            while(!dq.isEmpty() && dq.peek()[0]<i-k){
                dq.poll();
            }

            if(!dq.isEmpty()) cur+= dq.peek()[1]; //這邊都要留著, 之後可能會用到

            max = Math.max(cur, max);

            while(!dq.isEmpty() && dq.peekLast()[1] < cur){
                dq.pollLast();
            }

            if(cur>0) dq.offer(new int[]{i, cur});

        }

        return max;
         
        //  ///[10,2,-10,5,20]
        //  i==0:
        // max = 10
        // cur = 10
        // dq = {0, 10}

        // i==1:
        // cur =12
        // max = 12
        // dq = {1, 12}

        // i==2






        // 題目 找max sum of subseq 其中每個相鄰element j-i<=k
        // 想法1  : dp ? => O(NK) 會超時

        // int len = nums.length;
        // int[] dp = new int[len+1]; //  the maximum sum of a non-empty subsequence of that array  ending with nums[i-1];
        // Arrays.fill(dp, Integer.MIN_VALUE/2);
        // dp[1] = nums[0];
        // for(int j=2; j<=len; j++){
        //     dp[j] = Math.max(dp[j], nums[j-1]);
        //     for(int i=j-1; j-i<=k && i>0; i--){
        //         dp[j] = Math.max(dp[j], dp[i]+nums[j-1]);
        //     }
        // }
        // int res = Integer.MIN_VALUE;
        // for(int i=1; i<=len; i++){
        //     res = Math.max(res, dp[i]);
        // }
        // return res;

        // 也有treemap 的解法nlgn


        // practice


        // int len = nums.length;
        // int max = Integer.MIN_VALUE;
        // Deque<int[]> dq = new ArrayDeque<>(); // val, idx

        // for(int i=0; i<len; i++){

        //     //這邊很tricky
        //     int sum = nums[i] + (dq.isEmpty() ? 0 : dq.peek()[0]); // sum 是從dq來的
        //     max = Math.max(max, sum);

        //     //小的拉掉
        //     while(!dq.isEmpty() && dq.peekLast()[0]<sum){
        //         dq.pollLast();
        //     }

        //     // 過期的 0 1 2 3, k==3
        //     while(!dq.isEmpty() && dq.peek()[1]<=i-k){
        //         dq.poll();
        //     }

            
        //     if(sum>0){ //容易忘記: 有幫助的才加進dq
        //         dq.offer(new int[]{sum, i});
        //     }
        // }

        // return max;






/*




        // 想法2 : sliding window maximum (lc239), monostack O(N) :
        // max subarray sum的話想到presum(lc862)	subseq的話 直接加prev
        int len = nums.length;
        Deque<int[]> dq = new ArrayDeque<>(); // idx, total
        //[10,2,-10,5,20], k = 2

        int res = Integer.MIN_VALUE;

        for(int i=0; i<len; i++){
            
            // if dq not empty: previous total + nums
            int total = nums[i] + (!dq.isEmpty() ?  dq.peek()[1] : 0); 
            res = Math.max(res, total);
            
            // remove all the smaller answer
            while(!dq.isEmpty() && total > dq.peekLast()[1]){
                dq.pollLast();
            }

            // remove the out of date idx
            while(!dq.isEmpty() && i-dq.peek()[0]>=k){
                dq.poll();
            }

            if(total>0)
                dq.offer(new int[]{i, total});
        }

        return res;*/
    }
}