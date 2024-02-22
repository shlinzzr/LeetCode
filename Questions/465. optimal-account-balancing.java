// https://leetcode.com/problems/optimal-account-balancing

class Solution {
    public int minTransfers(int[][] trans) {
        
        
        // happygirlzt https://www.youtube.com/watch?v=HHKJPtsOGwk 
        
        int len = trans.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<len; i++){
            int f = trans[i][0];
            int t = trans[i][1];
            int a = trans[i][2];
            
            map.put(f, map.getOrDefault(f, 0)-a);
            map.put(t, map.getOrDefault(t, 0)+a);
        }
        
        
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> en : map.entrySet()){
            if(en.getValue()!=0)
                list.add(en.getValue());
        }
        
        return  dfs(0, list); // backtracking
        
    }
    
    
    private int dfs(int idx, List<Integer> list){
        if(idx==list.size())
            return 0;
        
        int cur = list.get(idx);
        if(cur==0)
            return dfs(idx+1, list);
        
        int min = Integer.MAX_VALUE;
        for(int i=idx+1; i<list.size(); i++){
            
            int next = list.get(i); // original
            if(next*cur<0){ //當balance互相為負才做事
                list.set(i, cur+next);
                min = Math.min(min , 1+dfs(idx+1, list));
                list.set(i, next); // recover to org
                
                if(cur+next==0) break;
            }
        }
        return min;
    }
    
    
    
}