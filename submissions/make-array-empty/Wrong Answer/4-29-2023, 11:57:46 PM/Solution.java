// https://leetcode.com/problems/make-array-empty

class Solution {
    public long countOperationsToEmptyArray(int[] nums) {
        long res = 0;
        int len = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int i=0; i<len; i++){
            map.put(nums[i], i);
            
        }
        int del = 0;
        int offset = 0;
        for(Map.Entry<Integer, Integer> en : map.entrySet()){
            
            int val = en.getKey();
            int idx = en.getValue();
            // System.out.print("v="+val + " idx=" + idx + " o=" + offset + " del="+del);
            
            if(idx-offset-del<0){
                 idx += (len-offset-del-del+1) ;
                
                while(idx<0)
                    idx+= (len-del);
            }
               
            else
                idx = idx-offset-del;
            
              // System.out.println( " idx=" + idx);
            
            res += idx;
            del++;
            offset += idx;
            res+=1;
            // len--;
                
            
            
            
        }
        
        return res;
        
        // 3 4 -1
        
        // -1, 2
        // 3, 0,
        // 4, 1
        
        // res += 3, offset = 2
        // 0 += (3-2)
        
    }
}