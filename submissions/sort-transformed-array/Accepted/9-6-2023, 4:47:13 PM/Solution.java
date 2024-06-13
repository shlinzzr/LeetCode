// https://leetcode.com/problems/sort-transformed-array

class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int len = nums.length;
        
        int[] res = new int[len];
        
        int st=0, ed=len-1;
        
        int idx = (a>0) ? len-1 : 0;
        
        while(st<=ed){
            
            int stVal = cal(nums[st], a, b, c);
            int edVal = cal(nums[ed], a, b, c);
            
            if(a>0){
                
                if(stVal>edVal){
                    res[idx] = stVal;
                    st++;
                }else{
                    res[idx] = edVal;
                    ed--;
                }
                idx--;
                
            }else{
                
                if(stVal<edVal){
                    res[idx] = stVal;
                    st++;
                }else{
                    res[idx] = edVal;
                    ed--;
                }
                idx++;
                
            }
        }
        
        return res;
        
        
        
    }
    
    private int cal(int x, int a, int b, int c) {
        return a*x*x + b*x + c;
    }
}
 