// https://leetcode.com/problems/sliding-puzzle

class Solution {
    public int slidingPuzzle(int[][] board) {
        
        int h = board.length;
        int w = board[0].length;
        String target = "123450";
        String state = "";
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                state += board[i][j];
            }
        }
        char[] arr = state.toCharArray();
        List<Integer>[] g = buildGraph();
        Set<String> seen = new HashSet<>();
        int step = 0;
        
        Queue<String> q = new LinkedList<>();
        q.offer(state);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                String p = q.poll();
                
                if(p.equals(target)) return step;
                
                int idx =p.indexOf("0");
                for(int adj : g[idx]){
                    
                    String nextState = swap(p, idx, adj);
                    
                    if(!seen.contains(nextState)){
                        seen.add(nextState);
                        q.offer(nextState);
                    }
                }
            }
            
            step++;
            
        }
        return -1;
        
        
//         123
//         405
            
//         ans 
//         state : 123450
        
            
//         assume:
//         012
//         345
//         0 : 1,3
//         1 : 0,2,4
//         2 : 1 5
//         3 : 0,4
//         4 : 1 3 5
//         5 : 2,4
            
        
        
    }
    
    private List<Integer>[] buildGraph(){
        
        List<Integer>[] g = new ArrayList[6];
        for(int i=0; i<6;i++) g[i] = new ArrayList<>();
        
        g[0] = new ArrayList<>( Arrays.asList(1,3) );
        g[1] = new ArrayList<>( Arrays.asList(0,2,4));
        g[2] = new ArrayList<>( Arrays.asList(1,5));
        g[3] = new ArrayList<>( Arrays.asList(0,4));
        g[4] = new ArrayList<>( Arrays.asList(1,3,5));
        g[5] = new ArrayList<>( Arrays.asList(2,4));
        return g;        
    }
    
    
    private String swap(String state , int i, int j){
        char[] arr =state.toCharArray();
        char ch = arr[i];
        arr[i] = arr[j];
        arr[j] = ch;
        
        return new String(arr);
    }
}