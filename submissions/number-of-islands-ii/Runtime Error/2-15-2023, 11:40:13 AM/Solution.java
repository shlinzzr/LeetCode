// https://leetcode.com/problems/number-of-islands-ii

class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        
        Map<Integer, Set<Integer>> map= new HashMap<>();
        
        
        int land = 0;
        int mark =1;
        int[][] grid = new int[m][n];
        
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1, 0}};        
        for(int[] p : positions){
            
            Set<Integer> set = new HashSet<>();
            for(int[] d : dirs){
                
                int r = p[0]+d[0];
                int c = p[1]+d[1];
                
                if(r<0 || r>=m || c<0 || c>=n)
                    continue;
                
                if(grid[r][c]!=0){
                    set.add(grid[r][c]);
                }
            }
            
            if(set.size()==0){
                land++;
                grid[p[0]][p[1]]=land;
                
            }else if(set.size()==1){
                int adj = set.iterator().next();
                grid[p[0]][p[1]]=adj;
                
            }else if(set.size()>1){
                
                int minus = set.size()-1;
                List<Integer> list = new ArrayList<>(set);
                int intersec =0, min=0;
                for(int i=0; i<list.size()-1; i++){
                    for(int j=i+1; j<list.size(); j++){
                        if(map.get(list.get(i)).contains(list.get(j))){
                            minus--;
                            min = Math.min(min, list.get(i));
                        }else{
                            map.get(list.get(i)).add(list.get(j));
                        }
                    }
                }
                
                land+=minus;                                
            }
            
            
                
            
            res.add(land);
        }
        
        
        return res;
        
        
    }
}