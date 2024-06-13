// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous

class Solution {
    public int minOperations(int[] nums) {
        int len = nums.length;
        
        Arrays.sort(nums);
        int maxLen= 1;
        int maxSt= 0; 
        int maxEd = 0;
            
            
        int st= 0 ;
        for(int i=0; i<len-1; i++){
            
            
            if(nums[i]+1==nums[i+1]){
                if(i+1-maxSt+1>maxLen){
                    maxLen = Math.max(maxLen,  i+1-maxSt+1 );
                    maxEd = i+1;
                    maxSt = st;
                }
            }else{
                st = i+1;
            }
        }
        
        if(maxSt==0 && maxEd==len-1)
            return 0;
        
        int res = 0;
        
        // [X X 2 3 5 6 7, 9 10, X, X]
                        // ^
        // System.out.println(maxSt + " " + maxEd + " " + maxLen);
        
        st=0;
        for(int ed=maxSt-1; ed>=st; ed--){
            if(nums[ed]+1!=nums[ed+1]){
                res++;
                // st++;
            }
        }
        
        int ed=len-1;
        for(st=maxEd+1; st<=ed; st++){
            
            // System.out.println(st + " " + ed);
            
            
            if(nums[st]-1 != nums[st-1]){
                res++;
                // ed--;
            }
        }
        
        return res;
        
        
        
        
        
        
        
        
        //[2,3,4,5] 5-2=3 = len-1
        
    }
}