// https://leetcode.com/problems/similar-string-groups

class Solution {
    public int numSimilarGroups(String[] strs) {
        int len = strs.length;
        
        UnionFind uf = new UnionFind(len);
        
        int res = len;
        
        for(int i=0; i<len ;i++){
            
            for(int j=i+1; j<len; j++){
                String a = strs[i];
                String b = strs[j];
                
                if(isSim(a, b)){
                    uf.union(i, j);
                    len--;
                }
                
                
                
                
            }
        }
        
        return len;
    }
    
    
    
    
    
    private boolean isSim(String a, String b){
        
        if(a.length()!=b.length())
            return false;
        
        if(a.equals(b))
            return true;
        
        int len = a.length();
        
        int cnt=0;
        
        for(int i=0; i<len ; i++){
            
            if(a.charAt(i)!=b.charAt(i))
                cnt++;
        }
        
        return cnt==0 || cnt==2;
    }
    
    
    class UnionFind{
        
        int[] parent;
        int[] weight;
        
        public UnionFind(int n){
            
            parent = new int[n];
            weight = new int[n];
               
            for(int i=0; i<n; i++){
                parent[i] = i;
            }
            
            Arrays.fill(weight, 1);
        }
        
        public int find(int x){
            
            if(parent[x]==x)
                return x;
            
            parent[x] = find(parent[x]);
            return parent[x];
        }
        
        public void union(int a, int b){
            
            int ra = find(a);
            int rb = find(b);
            
            if(ra==rb)
                return;
            
            if(weight[ra]>=weight[rb]){
                weight[ra] += weight[rb];
                parent[rb] = ra;
            }else{
                weight[rb] += weight[ra];
                parent[ra] = rb;
            }
        }
    }
}