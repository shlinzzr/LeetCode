// https://leetcode.com/problems/longest-path-with-different-adjacent-characters

class Solution {
    public int longestPath(int[] parent, String s) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        int len = parent.length;
        for(int i=0; i<len; i++) map.put(i, new ArrayList<>());
        
        
        
        int p=0;
        for(int i=0; i<parent.length; i++){
            if(parent[i]==-1)
                continue;
            
            map.get(i).add(parent[i]);
            map.get(parent[i]).add(i);
        }
        
        
        
        
        int max =0;
        

        
        for(int i=0; i<len; i++){
            int path=1;
            boolean[] seen = new boolean[len];
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            seen[i]=true;
            
            // System.out.println(i + " " + max);
            
            while(!q.isEmpty()){
                
                for(int j=q.size(); j>0; j--){
                    int curr = q.poll();
                    for(int next : map.get(curr)){
                       
                        if(seen[next]==false && s.charAt(next)!=s.charAt(curr)){
                            // System.out.println( "curr=" + curr + " " + next);
                            q.offer(next);
                            seen[next]=true;
                        }

                    }    
                }
                
                max = Math.max(max, path);
                path++;
            }
        }
        
        return max;
    }
}