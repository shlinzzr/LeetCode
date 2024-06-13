// https://leetcode.com/problems/sort-transformed-array

class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int len = nums.length;
        int st =0;
        int ed =len-1;
        int[] res = new int[len];
        int i=(a>=0)?  len-1 : 0;
        
        while(st<=ed){
            
            int stVal = cal(nums[st], a, b, c);
            int edVal = cal(nums[ed], a, b, c);
            // System.out.println(stVal + " " + edVal);
            if(a>=0){
                if(stVal>=edVal){
                    res[i]=stVal;
                    st++;
                }else{
                    res[i]=edVal;
                    ed--;
                }
                i--;
            }else{
                
                if(stVal>=edVal){
                    res[i]=stVal;
                    st++;
                }else{
                    res[i]=edVal;
                    ed--;
                }
                i++;
            }
        }
        
        return res;
        
        
        
    }
    
    
    private int cal(int x, int a, int b, int c){
        
        return x*x*a + b*x + c;
    }
}
