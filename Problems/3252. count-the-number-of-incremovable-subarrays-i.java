// https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-i

class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int len = nums.length;
        
        int cnt= 0 ;
        for(int win=0; win<nums.length; win++){
            
            for(int st=0; st+win<len; st++){
                int ed = st+win;
                
                List<Integer> list = new ArrayList<>();
            
                
                for(int i=0; i<len; i++){
                    
                    if(i<st || i>ed){
                      
                        list.add(nums[i]);
                    }
                }
                
                
                if(isAsc(list)){
                      // System.out.println(list + " true");
                    cnt++;
                }
                     // System.out.println(list );
            }
        }
        
        return cnt;
        
        
    }
    
    
    
    private boolean isAsc( List<Integer> list){
        
        for(int i=0; i<list.size()-1; i++){
            
            if(list.get(i)>=list.get(i+1)){
                return false;
            }
        }
        
        return true;
        
        
    }
    
}