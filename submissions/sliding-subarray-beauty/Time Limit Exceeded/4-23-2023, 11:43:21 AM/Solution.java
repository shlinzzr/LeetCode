// https://leetcode.com/problems/sliding-subarray-beauty

class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        
        int len = nums.length;
        
        int[] res = new int[len-k+1];
            
        List<Integer> list= new ArrayList<>();
          
        int st=0;
        for(int ed=0; ed<len;ed++){
          
            list.add(nums[ed]);
            
            
            if(list.size()<k)
                continue;
            
            if(list.size()>k){
                list.remove(0);
                st++;
            }
            
            boolean neg=false;
            
            // for(int l : list)
            //     System.out.print(l +",");
            //  System.out.println();
                    
            List<Integer> sort = new ArrayList<>(list);
            Collections.sort(sort);
            
             
//             for(int l : sort)
//                 System.out.print(l +",");
//              System.out.println();
            
            
            int i=0;
            for(int a : sort){
                // System.out.println(ed + " " + a + " " + st);
                if(i==x-1){
                    
                    if(a<=0)
                        res[st]=a;
                    else 
                        res[st]=0;
                    
                    break;
                }
                    
                    
                i++;
                
            }
            
        }
            
        return res;
        
    }
}