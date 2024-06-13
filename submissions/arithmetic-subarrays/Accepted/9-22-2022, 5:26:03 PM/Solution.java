// https://leetcode.com/problems/arithmetic-subarrays

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int len = l.length;
        
         List<Boolean> res = new ArrayList<>();
        
        for(int i=0; i<len; i++){   
            int st = l[i];
            int ed = r[i];
            
            
            int[] arr = new int[ed-st+1];
            for(int j=l[i]; j<=r[i]; j++){
                arr[j-l[i]] = nums[j];
            }
            
            Arrays.sort(arr);
            
            boolean bool = true;
            for(int k=0; k<arr.length-2; k++){
                if(arr[k+2]-arr[k+1]!=arr[k+1]-arr[k])
                    bool=false;
            }
            res.add(bool);            
        }
        
        return res;
             
    }
}