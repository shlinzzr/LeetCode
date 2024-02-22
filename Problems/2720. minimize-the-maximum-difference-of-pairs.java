// https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs

class Solution {
    public int minimizeMax(int[] nums, int p) {
        // 1 1 2 3 7 10 => max ([1,1], [2,3])  // [1 10], [3 10], [2 10]
        
        Arrays.sort(nums);
        int len = nums.length;
        
        int st =0, ed=nums[len-1]-nums[0];
        while(st<ed){
            
            int mid = st + (ed-st)/2;
            
            if(isOk(nums, p, mid)){
                ed = mid;
            }else{
                st = mid+1;
            }
            
            
        }
        return st;
    }
    
    private boolean isOk(int[] nums, int p, int mid){
        
        int len = nums.length;
        int cnt =0;
        
        for(int i=0;i<len-1; i++){
            
            if(nums[i+1]-nums[i]<=mid){
                cnt++;
                i++;
            }
        }
        
        return cnt>=p;
        
        
        
    }
    
}

// 1 2 2 4