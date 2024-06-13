// https://leetcode.com/problems/smallest-subarrays-with-maximum-bitwise-or

class Solution {
    public int[] smallestSubarrays(int[] nums) {
       
        //https://www.youtube.com/watch?v=npZ4NlpomeU
        
        // 難 概念有 不好實做
        
        
        int len = nums.length;
        int right = len-1;
        int[] res = new int[len];
        int[] arr = new int[32];
        
        // 由後往前 變成ed與left互換了
        for (int left=len-1; left>=0; left--)
        {
            
            // 整理arr : 把nums[left]灌進arr
            for (int k=0; k<32; k++){
                arr[k] += ((nums[left]>>k)&1);
            }
                
            
            
            while (right>left && isOK(nums[right], arr))
            {
                for (int k=0; k<32; k++)
                    arr[k] -= ((nums[right]>>k)&1);
                right--;
            }
            
            res[left] = right-left+1;
        }
        return res;
        
    }
    
    private boolean isOK(int num, int[] arr) { // right 可以往左移, 等於最後一位有沒有or 對sum 沒有影響
        for (int k=0; k<32; k++) {
            if (arr[k] > 0 && (arr[k] - ((num>>k)&1) <= 0)) 
                return false;
        }
        return true;
    }
    
}