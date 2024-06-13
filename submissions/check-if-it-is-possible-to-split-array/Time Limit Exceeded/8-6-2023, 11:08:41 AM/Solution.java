// https://leetcode.com/problems/check-if-it-is-possible-to-split-array

class Solution {
    public boolean canSplitArray(List<Integer> nums, int m) {
        
        int len = nums.size();
        if(len<=2)
            return true;
        
        List<Integer> list = new ArrayList<>();
        
        
        boolean head = false;
        boolean tail = false;
        
        int sum=0;
        for(int i=0;i<len-1; i++){
            sum += nums.get(i);
            
            
            
            if(sum>=m ){
                
               // System.out.println(nums.subList(0, i+1));
                 
                 head = canSplitArray(nums.subList(i+1, len), m) &&  canSplitArray(nums.subList(0, i+1), m);
            }
        }
        
        sum=0;
        for(int i=len-1; i>0; i--){
            sum += nums.get(i);
            if(sum>=m ){
                
                 // System.out.println(nums.subList( i,len));
                tail = canSplitArray(nums.subList(0, i), m) &&  canSplitArray(nums.subList(i, len), m);
            }
                
                
                
            
        }
        
        return head || tail;
        
    }
}