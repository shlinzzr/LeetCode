// https://leetcode.com/problems/movement-of-robots

class Solution {
    public int sumDistance(int[] nums, String s, int d) {
        int len = nums.length;
        int[] arr = new int[len];
        
        for(int i=0; i<s.length();i++){
            
            if(s.charAt(i)=='R')
                arr[i]=1;
            else 
                arr[i]=-1;
        }
        
        
        boolean[] frz = new boolean[len];
        
        while(d>0){
            
            for(int i=0; i<len-1; i++){
                
                if(nums[i]==nums[i+1] && arr[i]==1 && arr[i+1]==-1){
                    arr[i]=-1; 
                    arr[i+1]=1;
                }
                
                else if(nums[i]+1 == nums[i+1] && arr[i]==1 && arr[i+1]==-1){
                    frz[i]=true;
                    frz[i+1]=true;
                    arr[i]=-1; 
                    arr[i+1]=1;
                }
            }
            
            
            for(int i=0; i<len ; i++){
                
                if(frz[i]==true){
                    frz[i]=false;
                }else{
                    nums[i]+=arr[i];
                }
            }
            
            
            d--;
        }
        
        
        int res = 0;
        for(int i = 0; i<len-1; i++){
            
            for(int j=i+1; j<len; j++){
                 int val = Math.abs(nums[i]-nums[j]);
                  // System.out.println(val);
                 res += val;
            }
          
           
        }
        
        return res;
    }
}