// https://leetcode.com/problems/optimal-account-balancing

class Solution {
    public int minTransfers(int[][] tran) {
        int len = tran.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<len; i++){
            int f = tran[i][0];
            int t = tran[i][1];
            int a = tran[i][2];
            
            map.putIfAbsent(f ,0);
            map.putIfAbsent(t ,0);
            
            map.put(f, map.get(f)-a);
            map.put(t, map.get(t)+a);
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(Map.Entry<Integer, Integer> en : map.entrySet()){
            
            if(en.getValue()!=0)
                list.add(en.getValue());
        }
        
        return  dfs(0, list);
        
    }
    
    
    private int dfs(int k, List<Integer> list){
        if(k==list.size())
            return 0;
        
        int cur = list.get(k);
        if(cur==0)
            return dfs(k+1, list);
        
        int min = Integer.MAX_VALUE;
        for(int i=k+1; i<list.size(); i++){
            int next = list.get(i);
            if(next*cur<0){
                list.set(i, cur+next);
                min = Math.min(min , 1+dfs(k+1, list));
                list.set(i, next);
                
                if(cur+next==0) break;
            }
        }
        return min;
    }
    
    
    
    
    
}

