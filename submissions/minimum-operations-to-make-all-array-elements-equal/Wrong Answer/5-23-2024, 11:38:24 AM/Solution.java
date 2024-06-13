// https://leetcode.com/problems/minimum-operations-to-make-all-array-elements-equal

class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        int m = queries.length;
        Arrays.sort(nums);

        int len = nums.length;

        int[] presum = new int[len];
        int[] sufsum = new int[len];
        for(int i=0; i<len; i++){
            presum[i] = i==0? nums[i] : nums[i]+presum[i-1];
            int idx = len-i-1;
            sufsum[idx] = idx==len-1 ? nums[idx] : nums[idx]+sufsum[idx+1];
        }


        List<Long> res = new ArrayList<>();
        for(int i=0; i<m; i++){
            int q = queries[i];
            int idx = bs(nums, q);
            System.out.println(idx);

        //  2   3  6  9 
        //        
        //p 2   5 11 20
        //s 20 18 15  9
            

            //  System.out.println(q*(idx+1)- presum[idx]);
            //      System.out.println(sufsum[idx]-(q*(len-idx)));


            res.add( (long)q*(idx+1)- presum[idx] + (long)sufsum[idx]-(q*(len-idx)) + Math.abs(q-nums[idx]));
        }

        return res;

        
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