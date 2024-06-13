// https://leetcode.com/problems/cheapest-flights-within-k-stops

class Solution {
    
    int price = Integer.MAX_VALUE;
    int dest;
    int[][] priceList;
    int kk;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        priceList = new int[n][n];
        dest = dst;
        kk=k;
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        
        for(int[] f : flights){
            
            priceList[f[0]][f[1]] = f[2];
            map.putIfAbsent(f[0], new HashSet<>());
            map.get(f[0]).add(f[1]);
        }
        
        boolean[] seen = new boolean[n];
        dfs(src, 0, map, seen, 0);        
        
        return price;
        
        
    }
    
    
    private void dfs(int cur, int p,  HashMap<Integer, Set<Integer>> map, boolean[] seen, int k){
        
        
        if(cur==dest){
            price=Math.min(price, p);
            return;
        }
        
        if(kk+1==k)
            return;
        
        Set<Integer> set = map.get(cur);
        if(set==null)
            return;
        
        for(int next : set){
            
            if(seen[next]==false){
                seen[next]=true;
                p+=priceList[cur][next];
                dfs(next, p, map, seen, k+1);
                seen[next]=false;
                p-=priceList[cur][next];
            }
            
            
        }
        
        
        
    }
}