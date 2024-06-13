// https://leetcode.com/problems/maximum-number-of-weeks-for-which-you-can-work

class Solution {
    public long numberOfWeeks(int[] m) {
          int len = m.length;
        long sum=0;
        long max = 0;
        for(int i=0; i<len; i++){
            
            sum+=m[i];
            max = Math.max(max, m[i]);
        }
        
        if(max<sum/2)
            return sum;
        
        
           // int dis = max-total/2;
           //  return total-dis;
        
        //xxxxxxxxxxxxxxxxxxxxxxxxxooooaaxxbbb
        //                |>-dis<-|<-others->|
        
        int others= sum-max;
        
        return others*2+1;
        
        /*
        
        
        
        // follow 767 TLE:
        
      
        
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b)-> b[1]-a[1]); // idx, cnt
        
        for(int i=0; i<len; i++){
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
        
//         return res;*/
        
    }
}