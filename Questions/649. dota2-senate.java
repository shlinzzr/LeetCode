// https://leetcode.com/problems/dota2-senate

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        int len = senate.length();
        
        for(int i=0; i<len; i++){
            
            if(senate.charAt(i)=='R')
                q1.offer(i);
            else 
                q2.offer(i);
        }
        
        
        while(!q1.isEmpty() && !q2.isEmpty()){
            
            int r = q1.poll();
            int d = q2.poll();
            
            if(r<d){
                q1.offer(r+len);
            }else{
                q2.offer(d+len);
            }
        }
        
        return q1.size()>q2.size() ? "Radiant" : "Dire";
        
    }
}