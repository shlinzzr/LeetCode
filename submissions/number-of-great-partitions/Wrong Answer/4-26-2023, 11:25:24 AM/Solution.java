// https://leetcode.com/problems/number-of-great-partitions

class Solution {
    
    // https://www.youtube.com/watch?v=V7wdVxiPFCU
    
    public int countPartitions(int[] nums, int k) {
        int len = nums.length;
        int st = -1;
        long[] presum = new long[len];
        for(int i=0; i<len; i++){
            if(i==0)
                presum[0] = (long)nums[0];
            else
                presum[i] = (long)presum[i-1] + (long)nums[i];
            
            if(st==-1 && presum[i]>=k)
                st=i;
        }
        
        int ed = len;
        for(int i = len-2; i>=0; i--){
            if(presum[len-1] -presum[i]>=k ){
                ed=i+1;
                break;
            }
                
        }            
            
        System.out.println(st + " " + ed) ;
        if(st>=ed)
            return 0;
        
        return (int)Math.pow(2, (ed-st-1));
        
        
    }
}