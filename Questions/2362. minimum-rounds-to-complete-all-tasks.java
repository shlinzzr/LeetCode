// https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks

class Solution {
    public int minimumRounds(int[] tasks) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int t: tasks){
            
            map.put(t, map.getOrDefault(t, 0)+1);
        }
        
        int res=0;
        for(int key : map.keySet()){
            if(map.get(key)==1)
                return -1;
            
            res+= map.get(key)/3;
            if(map.get(key)%3!=0)
                res+=1;
        }
        
        return res;
        
    }
}