// https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x

class Solution {
    public int specialArray(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        
        
        int st =1, ed = nums[len-1];
        
        while(st<ed){
            
            int m = st + (ed-st)/2;
            
            // System.out.println(st + " " + ed + " m=" + m +" c=" +getCnt(nums, m));
            
            if(getCnt(nums, m)==m){
                
                return m;
                
            }else if(getCnt(nums, m)>m){
                st = m+1;
                
            }else{
                ed = m-1;
                
            }
            
        }
        
        if(getCnt(nums, st)==st)
            return st;
        
        return -1;
        
            
        
        
            
            
            
            
    }
    
    private int  getCnt(int[] nums, int x){
        
        int cnt = 0;
        for(int n : nums){
            if(n>=x){
                cnt++;
            }
        }
        
        return cnt;
    }
    
}