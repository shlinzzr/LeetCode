// https://leetcode.com/problems/find-latest-group-of-size-m

class Solution {
    public int findLatestStep(int[] arr, int m) {
        int len = arr.length;

        if(m==len) return len;

        int[] day = new int[len]; // day : 1-index, 

        for(int i=0; i<len; i++){
            day[arr[i]-1]=i+1;
        }

        Deque<Integer> dq = new ArrayDeque<>();

        int res = Integer.MIN_VALUE;

        // sliding (window size m)'s maximum  : [i, j] = t
        // for i到j區間 [i, j] 都必須<t, 且(day[i-1]>t && day[j+1]>t ) , 
        // 意思即是在 t = min(day[i-1], day[j+1])-1 前 就是latest step 
        for(int j=0; j<len; j++){
            while(!dq.isEmpty() && day[dq.peekLast()]<day[j]){
                dq.pollLast();
            }
            while(!dq.isEmpty() && j-dq.peek()+1>m){
                dq.poll();
            }
            dq.offer(j);

            // m=5 : x x x j-m [x x x x j] j+1

            int t = day[dq.peek()];
            if(j-m>=0 && day[j-m]>t && j+1<len && day[j+1]>t){
                res = Math.max(res,  Math.min(day[j-m], day[j+1]));
            }
        }

        return res == Integer.MIN_VALUE ? -1 : res;
        
    }
}