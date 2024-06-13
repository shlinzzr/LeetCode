// https://leetcode.com/problems/sliding-subarray-beauty

class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int len = nums.length;
        
        
        int[] counter = new int[50];
        int[] res = new int[len-k+1];
        
        
        for(int ed=0; ed<len; ed++){
            if(nums[ed]<0)
                counter[nums[ed]+50]++;
            
            if(ed-k>=0 && nums[ed-k]<0)
                counter[nums[ed-k]+50]--;
            
            if(ed-k+1<0) continue;
                
            for(int j=0, cnt=0; j<50; j++){
                cnt+=counter[j];
                if(cnt>=x){
                    res[ed-k+1] = j-50;
                    break;
                }
            }
            
        }
        
        return res;
        
    }
    
    /*
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] counter = new int[50], ans = new int[nums.length - k + 1];;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) counter[nums[i] + 50]++;
            if (i - k >= 0 && nums[i - k] < 0) counter[nums[i - k] + 50]--;
            if (i - k + 1 < 0) continue;
            for (int j = 0, count = 0; j < 50; j++) {
                count += counter[j];
                if (count >= x) {
                    ans[i - k + 1] = j - 50;
                    break;
                }
            }
        }
        return ans;
    }*/
}