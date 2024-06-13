// https://leetcode.com/problems/apply-operations-to-make-sum-of-array-greater-than-or-equal-to-k

class Solution {
    public int minOperations(int k) {
        
        // (1 +a) *b >=k
        // b + ab >= k
        
        int min = k-1;
        for(int a=0; a<k; a++){
            // a:0 b:4
            // a:1 b:2
            // int b = k/(a+1) ;
            int b = k%(a+1)==0 ? k/(a+1) : k/(a+1)+1;

            
            min= Math.min(min , a+b-1);
        }
        
        return min;

            
//         List<Integer> list = new ArrayList<>();
//         list.add(1);
        
//         Set<List<Integer>> seen = new HashSet<>();
        
//         Queue<List<Integer>> q = new LinkedList<>();
//         int step = 0;
//         q.offer(list);
//         while(!q.isEmpty()){
            
//             int siz = q.size();
//             while(siz-->0){
                
//                 List<Integer> p = q.poll();
//                 // System.out.println(step + " " + p);
                
                
//                 int sum = 0;
//                 for(int a : p){
//                     sum+=a;
//                 }
                
//                 if(sum>=k) return step;
                
                
//                 for(int i=0; i<p.size(); i++){
//                     int a = p.get(i);
                    
                    
//                   List<Integer> next1 = new ArrayList<>(p);
//                   next1.set(i , a+1);
                    
//                   if(seen.add(next1)){
//                       q.offer(next1);
//                   }
                    
                    
//                     List<Integer> next2 = new ArrayList<>(p);
//                     next2.add(a);
                    
//                     if(seen.add(next2)){
//                         q.offer(next2);
//                     }
//                 }
                    
                
                
//             }
            
            
//             step++;
//         }
        
//         return -1;
        
         
//         1 
            
//         a : +1
//         b : +n
            
//         => k
            
            
//         k/2
            
//         ex : 11
//         target 6:
        
    }
}