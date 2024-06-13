// https://leetcode.com/problems/count-distinct-numbers-on-board

class Solution {
    public int distinctIntegers(int n) {
        HashSet<Integer>set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        set.add(n);
        
        while(!q.isEmpty()){
            
            int p= q.poll();
            
            for(int i=2; i<=p; i++){
                
                if(p%i==1){
                    q.offer(i);
                    set.add(i);
                }
            }
        }
        
        return set.size();
        
        
    }
}