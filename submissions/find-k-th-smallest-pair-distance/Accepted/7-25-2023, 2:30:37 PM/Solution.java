// https://leetcode.com/problems/find-k-th-smallest-pair-distance

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        
        int len = nums.length;
        
        int st=0, ed=nums[len-1]-nums[0];
        
        while(st<ed){
            
            int abs = st+ (ed-st)/2;
            
            int count = 0, left = 0; // count is the pair cnt, whose distance is below abs // 求差值小於等於abs的數組有幾個
            for(int right=0; right<len; right++){
                while(nums[right]-nums[left]>abs){
                    left++;    // left是單調遞增不用重新開始
                }
                count += right-left; //此時的nums[right]-nums[left]都會在abs內 數量給他加起來!!!
            }
            
            if(count>=k)
                ed = abs;
            else
                st= abs+1;
        }
        
        return st;
        
        
        
        
        
        
    }
}