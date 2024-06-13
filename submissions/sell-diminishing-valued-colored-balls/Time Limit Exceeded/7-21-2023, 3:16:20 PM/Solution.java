// https://leetcode.com/problems/sell-diminishing-valued-colored-balls

class Solution {
    public int maxProfit(int[] in, int orders) {
        int len = in.length;
        
        int M =(int) 1e9+7;
        
        int st = 1, ed = Integer.MAX_VALUE;
        
        while(st<ed){
            
            int val = st + (ed-st)/2;
            
            // System.out.println(st +" " + ed + " v=" + val + " b=" + isOk(in, val, orders));
            
            if(isOk(in, val, orders)){
                ed = val;
            }else{
                st = val+1;
            }
        }
        
        
        if(isOk(in, st, orders)){
            return st;
        }else if(isOk(in, st, orders)){
            return st +1;
        }
        
        return -1;
        
    }
    
    private boolean isOk(int[] in , int val, int orders){
        
        int M =(int) 1e9+7;
        
        int len = in.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> b-a
        );
        
        for(int i: in)
            pq.offer(i);
        
        int res = 0;
        while(orders>0 && !pq.isEmpty()){
            
            int p = pq.poll();
            res = (res + p)%M;
            if(p!=0)
                pq.offer(p-1);
            
            orders--;
        }
        
        return val >= res;
        
        
        
        
    }
}