// https://leetcode.com/problems/maximum-number-of-weeks-for-which-you-can-work

class Solution {
    public long numberOfWeeks(int[] m) {
        
        // follow 767 TLE:
        
        int len = m.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b)-> b[1]-a[1]); // idx, cnt
        
        int total=0;
        int max = 0;
        for(int i=0; i<len; i++){
            
            total+=m[i];
            max = Math.max(max, m[i]);
            
            pq.offer(new int[]{i, m[i]});
        }
        
        if(max>total/2){
            int dis = max-total/2;
            return total-dis;
        }else{
            return total;
        }
        
        
        
//         long res=0;
//         Integer prev = null;
        
//         while(!pq.isEmpty()){
            
//             int[] first = pq.poll();
            
//             if(prev==null || prev!=first[0]){
                
//                 res++;
//                 prev = first[0];
//                 if(--first[1]>0)
//                     pq.offer(first);
//             }else{
               
//                 if(pq.isEmpty())
//                     break;
                
//                 int[] second = pq.poll();
//                 res++;
//                 prev = second[0];
//                 if(--second[1]>0)
//                     pq.offer(second);
                
//                 pq.offer(first);
//             }
//         }
        
//         return res;
        
    }
}