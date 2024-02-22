class Solution {
    
    
    
    int[][] dirs = new int[][]{{0,1},{1,1}, {1,0},{1,-1},{0,-1},{-1,-1},{-1,0}, {-1,1}};
    
    Map<Integer, Integer> map = new HashMap<>();
    int h;
    int w;
    int maxFreq=0;
    int ans=-1;
    
    public int mostFrequentPrime(int[][] mat) {
        
        
        h = mat.length;
        w = mat[0].length;
        
        
//         Set<String> seen = new HashSet<>();
//         seen.add("0_0");
        
        String s =  mat[0][0]+"";
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                 for(int[] d : dirs){
                     
                     dfs(mat, i, j, mat[i][j]+"", d);
            
            
            
                 }
            }
        }
       
        
        
        // dfs(mat, 0, 0, s, seen);
        
        
//         for(int k : map.keySet()){
//             System.out.println(k + " "+  map.get(k));
//         }
        
        return ans;
        
    }
    
    
    private void dfs(int[][] mat, int x, int y, String curr,int[] d){
        
        
        
            int r = x+d[0];
            int c = y+d[1];
            
            if(r<0 || c<0 || r>=h || c>=w) return;
            
            int val = Integer.valueOf(curr+mat[r][c]);
            
            if(isPrime(val)) {
                 map.put(val, map.getOrDefault(val, 0)+1);
                
                int freq = map.get(val);
                
                if(freq>maxFreq){
                    maxFreq = freq;
                    ans = val;
                }else if(freq==maxFreq){
                    if(val>ans)
                        ans = val;
                }
            }
               
            
            dfs(mat, r, c, val+"", d);
            
        
        
    }
    
    
    
     
    public boolean isPrime(int n)
    {
        if(n<2)
        {
            return false;
        }
        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(n%i==0)
            {
                return false;
            }
        }
        return true;
    }
    
}