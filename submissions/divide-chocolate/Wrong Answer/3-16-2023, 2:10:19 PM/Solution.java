// https://leetcode.com/problems/divide-chocolate

class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        Arrays.sort(sweetness);
        
        int total=0;
        for(int sw : sweetness){
            total+=sw;
        }
        
        int st = 0, ed =total, ans=0;
        while(st<ed){
            int mid = st+(ed-st)/2;
            
            boolean bool =  isValid(sweetness, k+1, mid);
            if(bool){
                st=mid;
                ans=mid;
                
            }else{
                ed=mid-1;
            }
        }
        return ans;
    }
    
    
    
    private boolean isValid(int[] arr, int k, int low){
        int sum =0;
        for(int i=0; i<arr.length; i++){
            
            sum+=arr[i];
            
            if(sum>=low){
                k--;
                sum=0;
            }
        }
        
        return k>0?false : true;
        
    }
}