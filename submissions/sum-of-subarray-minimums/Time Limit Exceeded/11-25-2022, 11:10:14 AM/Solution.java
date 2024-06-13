// https://leetcode.com/problems/sum-of-subarray-minimums

class Solution {
    public int sumSubarrayMins(int[] arr) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            for(int j=1; j<=arr.length;j++){
                
                List<Integer> list = new ArrayList<>();
                for(int k=i; k<j; k++){
                    
                    list.add(arr[k]);
                }
                if(list.size()>0)
                    res.add(list);
                
            }
        }
        
        
        int sum = 0;
        
        for(List<Integer> list : res){
            
            Integer min = Integer.MAX_VALUE;
            for(int i : list){
                min = Math.min(min ,i );
                 // System.out.print( i + ", ");
            }
            
            // System.out.println(", min=" + min);
            
            sum+=min;            
        }
        
        
        return sum;
        
        
        
    }
    
}