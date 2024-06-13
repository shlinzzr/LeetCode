// https://leetcode.com/problems/smallest-subarrays-with-maximum-bitwise-or

class Solution {
    public int[] smallestSubarrays(int[] nums) {
       
        //https://www.youtube.com/watch?v=npZ4NlpomeU
        
        // 難 概念有 不好實做
        
        
        int len = nums.length;
        int ed = len-1;
        int[] res = new int[len];
        int[] arr = new int[32];
        
        
        for (int st=len-1; st>=0; st--)
        {
            for (int k=0; k<32; k++){
                arr[k] += ((nums[st]>>k)&1);
            }
                
            
            while (ed>st && isOK(nums[ed], arr))
            {
                for (int k=0; k<32; k++)
                    arr[k] -= ((nums[ed]>>k)&1);
                ed--;
            }
            
            res[st] = ed-st+1;
        }
        return res;
        
    }
    
    private boolean isOK(int num, int[] arr) { //ed可以往左移, 等於最後一位有沒有or 對sum 沒有影響
        for (int k=0; k<32; k++) {
            if (arr[k] > 0 && (arr[k] - ((num>>k)&1) <= 0)) 
                return false;
        }
        return true;
    }
    
}