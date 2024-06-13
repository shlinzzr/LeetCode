// https://leetcode.com/problems/possible-bipartition

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
     
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<=n; i++)
            list.add(new ArrayList<>());
        
        for(int[] d : dislikes){
            list.get(d[0]).add(d[1]);
            list.get(d[1]).add(d[0]);
        }
        
        int[] color = new int[n+1];
        
        for(int i=0;i<=n;i++){
            
            if(color[i]==0){
                color[i]=1;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                
                while(!q.isEmpty()){
                    
                    int curr = q.poll();
                    List<Integer> nebs = list.get(curr);
                    for(int nb : nebs){
                        
                        if(color[nb]==0){
                            color[nb] = color[curr]==1? 2: 1;
                            q.add(nb);
                            
                        }else{
                            if(color[curr]==color[nb]){
                                return false;
                            }    
                        }
                    }
                }
            }
        }
        
        return true;
        
        
      
        
    }
        
}