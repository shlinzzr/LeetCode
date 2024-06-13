// https://leetcode.com/problems/minimum-increment-operations-to-make-array-beautiful

class Solution {
    public long minIncrementOperations(int[] nums, int k) {
        int len = nums.length;
        
        long res = 0;
        for(int i=0; i<len-2; i++){
            
            int n1 = nums[i];
            int n2 = nums[i+1];
            int n3 = nums[i+2];
            
            int max = Math.max(n1, Math.max(n2, n3));
              System.out.println(i + " " + max);
            if(k>max){
              
                res += k-max;
                
                if(max==n3)
                    nums[i+2]=k;
                else if(max==n2)
                    nums[i+1]=k;
                else 
                    nums[i]=k;
            }
        }
        
        return res;
        
        
        
        
        
        
        
        
        
        
//         long res = 0;
//         int st = 0;
        
//         HashMap<Integer, Integer> idxMap = new HashMap<>();
        
//         TreeMap<Integer, Integer> map = new TreeMap<>();
//         for(int ed=0; ed<len; ed++){
//             map.put(nums[ed], map.getOrDefault(nums[ed],0)+1);
//             idxMap.put(nums[ed], ed);
            
//             if(ed<2)
//                 continue;
            
// //             System.out.println("ed="+ed + " last="+map.lastKey());
            
// //             // System.out.println("nums[1]="+nums[1]);
// //             System.out.println("idxMap.keySet()="+idxMap.get(3));
            
            
//             if(map.lastKey()<k){
//                 int last = map.lastKey();
//                 long diff = (long) (k-last);
//                 res+= diff;
//                 map.put(k, 1);
//                 nums[idxMap.get(last)] = k;
                
//                 map.put(last, map.getOrDefault(last,0)-1);
//                 if(map.get(last)==0)
//                      map.remove(last);
                
                
//             }
//             System.out.println(map.keySet());
            
//             map.put(nums[st], map.getOrDefault(nums[st],0)-1);
//             if(map.get(nums[st])==0)
//                 map.remove(nums[st]);
            
//         }
//         return res;
            
    }
}