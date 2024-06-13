// https://leetcode.com/problems/valid-triangle-number

class Solution {
    public int triangleNumber(int[] nums) {
        int len = nums.length;
        
        Arrays.sort(nums);
        int cnt= 0;
        for(int i=0; i<len-2 ;i++){
            
            for(int j=i+1; j<len-1; j++){
                
                
                for(int k=j+1; k<len ;k++){
                    if(isValid(nums[i], nums[j], nums[k]))
                        cnt++;
                }
                
            }
            
        }
        
        return cnt;
        
        
    }
    
    private boolean isValid (int a, int b, int c){
        
        if(a+b<=c)
            return false;
        
        if(b+c<=a)
            return false;
        
        if(c+a<=b)
            return false;
        
        
        return true;
        
        
    }
}