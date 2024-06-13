// https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs

class Solution {
    public int minimizeMax(int[] nums, int p) {
        // 1 1 2 3 7 10 => max ([1,1], [2,3])  // [1 10], [3 10], [2 10]
        
        Arrays.sort(nums);
        int len = nums.length;
        
        int st =0, ed=nums[len-1]-nums[0];
        while(st<ed){
            int k = 0;
            int mid = st + (ed-st)/2;
            
            for(int i=1; i<len && k<p; i++){
                if(nums[i]-nums[i-1]<=mid){
                    k++;
                    i++;
                }
            }
            
            if(k>=p)
                ed=mid;
            else{
                st = mid+1;
            }
        }
        
        return st;
        
        
    }
}

// 1 2 2 4