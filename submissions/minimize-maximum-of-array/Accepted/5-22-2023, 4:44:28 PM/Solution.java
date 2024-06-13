// https://leetcode.com/problems/minimize-maximum-of-array

class Solution {
    public int minimizeArrayValue(int[] nums) {
        int len = nums.length;
        
        
        int left = nums[0], right = (int)1e9;
        while (left < right)
        {
            int mid = left+(right-left)/2;
            
            long buff = 0;
            boolean flag = true;
            
            for (int i=0; i<nums.length; i++)
            {
                int x = nums[i];
                if (x > mid)
                    buff -= (x-mid);
                else
                    buff += (mid-x);                
                if (buff < 0)
                {
                    flag = false;
                    break;
                }
            }
            
            if (flag)
                right = mid;
            else
                left = mid+1;
        }
        
        return left;
        
        
    }
}