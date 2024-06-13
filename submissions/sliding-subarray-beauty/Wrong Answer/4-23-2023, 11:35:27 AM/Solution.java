// https://leetcode.com/problems/sliding-subarray-beauty

class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        
        int len = nums.length;
        
        TreeSet<Integer> set = new TreeSet<>();
        int[] res = new int[len-k+1];
            
            
        
        int st=0;
        for(int ed=0; ed<len;ed++){
            set.add(nums[ed]);
            
            
            if(set.size()<k)
                continue;
            
            if(set.size()>k){
                set.remove(nums[st++]);
            }
            
            boolean neg=false;
            int i = 0;
            for(int a : set){
                System.out.println(ed + " " + a + " " + st);
                if(i==x-1){
                    
                    if(a<=0)
                        res[ed-k+1]=a;
                    else 
                        res[ed-k+1]=0;
                    
                    break;
                }
                    
                    
                i++;
                
            }
            
        }
            
        return res;
        
    }
}