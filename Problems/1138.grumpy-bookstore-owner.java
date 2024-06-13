// https://leetcode.com/problems/grumpy-bookstore-owner

class Solution {
    public int maxSatisfied(int[] cust, int[] G, int minutes) {
        
        
        int max=0;
        
        int len = cust.length;
        
        int st=0;
        
        int sum = 0;
        
        int total=0;
        
        for(int i=0; i<len; i++){
            
            if(G[i]==0)
                total+=cust[i];
        }
        
        
        
        for(int ed=0; ed<len; ed++){
            
            sum+=G[ed]*cust[ed];
            
            if(ed-st+1<=minutes){
                max = Math.max(max, sum);
            }
            
            if(ed-st+1==minutes){
                sum-=G[st]*cust[st];
                st++;
            }
        }
        
        
        return total+max;
        
    }
}