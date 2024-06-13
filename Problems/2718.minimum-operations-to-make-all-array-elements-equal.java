// https://leetcode.com/problems/minimum-operations-to-make-all-array-elements-equal

class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        int m = queries.length;
        Arrays.sort(nums);

        int len = nums.length;

        long[] presum = new long[len+1];
        for(int i=1; i<=len; i++){
            presum[i] =  nums[i-1]+presum[i-1];
        }

        List<Long> res = new ArrayList<>();
        for(int i=0; i<m; i++){
            long q = (long)queries[i];
            int k = bs2(nums, q);
            res.add( q*k-presum[k] + (presum[len]-presum[k]) - q*(len-k)  );
        }

        return res;

        
    }
    //找第一個> q. 的數字 是因為要方便符合presum的定義
    private int bs2(int[] nums, long q){
        int len = nums.length;

        int st= 0, ed=len;
        while(st<ed){
            int mid = st+(ed-st)/2;
            if(nums[mid]<q){
                st = mid+1;
            }else
                ed = mid;
        }
        return st;


    }
    private int bs(int[] nums, int q){

        int len = nums.length;

        int st=0, ed=len-1;

        while(st<ed){
            int mid = st+(ed-st)/2;

            if(nums[mid]==q) return mid;
            else if(nums[mid]<q){
                st = mid+1;
            }else 
                ed = mid-1;
        }

        if(st+1<len && st-1>=0){

            int a = Math.abs(nums[st-1]-q);
            int b = Math.abs(nums[st]-q);
            int c = Math.abs(nums[st+1]-1);

            if(a<=b && a<=c) return st-1;
            if(b<=a && b<=c) return st;
            if(c<=a && c<=b) return st+1;

            return st;
        }


        if(st+1<len){

            int b = Math.abs(nums[st]-q);
            int c = Math.abs(nums[st+1]-1);
            if(b<=c) return st;
            return st+1;
        }

        if(st-1<len){
            int a = Math.abs(nums[st-1]-q);
            int b = Math.abs(nums[st]-q);

            if(a<b) return st-1;
            return st;
        }

        return st;


    }
    
}