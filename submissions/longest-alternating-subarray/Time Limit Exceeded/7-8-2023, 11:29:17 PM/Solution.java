// https://leetcode.com/problems/longest-alternating-subarray

class Solution {
    public int alternatingSubarray(int[] nums) {
        int len = nums.length;
      
        int max= -1;
     
        Integer p = null;
         // 2 3 4 3 4
        int cnt= 1;
        
        int st = -1;
        for(int i=0; i<len-1; i++){
            // 2
            int cur = nums[i]; //4
            int nxt = nums[i+1]; // 3
            
            
            if( (p!=null && cur+p==nxt) ||  p==null && (cur+1==nxt || cur-1==nxt) ){
                cnt++; //2
                max = Math.max(max, cnt); //
                
                if(p==null){
                    p = cur-nxt; //-1
                }else{
                    p=-p;
                }
                
                
                
            }else{
                i--;
                cnt = 1;
                p=null;
                
            }
            
            // System.out.println(i + " " + cur + " " +nxt);
            
        }
               
               return max;
     
        
        
//         TreeMap<Integer, Integer> map = new TreeMap<>();
        
//         for(int i=0; i<len; i++){
            
//             int n = nums[i];
            
//             map.put(n, map.getOrDefault(n, 0)+1);
//         }
        
        
        
//         int i1 = -1, i2=-1;
        
//         int max= -1;
//         List<Integer> list = new ArrayList<>(map.keySet());
//         for(int i=0; i<list.size()-1; i++){
            
//             int cur = list.get(i);
//             int nxt = list.get(i+1);
            
//             if(cur!=nxt+1 && cur!=nxt-1)
//                 continue;
            
//             int min = Math.min(map.get(cur), map.get(nxt));
           
//             if(min>max){
                
//                 i1=cur;
//                 i2=nxt;
//                 max = Math.max(max, min);
//             }
            
          
            
//         }
        
//         return max==-1 ? -1 : 2*max ;
        
        
        
    }
}