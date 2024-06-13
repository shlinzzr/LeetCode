// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        
        int h = maze.length;
        int w = maze.length;
        boolean[][] visited = new boolean[h][w];
        
        Stack<int[]> st = new Stack<>();
        
        st.push(entrance);
        visited[entrance[0]][entrance[1]]=true;
        
        int[][] dirs = new int[][]{{1,0}, {0,1}, {-1, 0}, {0, -1}};
        
        int cnt=0;
        
        while(!st.isEmpty()){
            
            int siz = st.size();
            for(int i=0; i<siz; i++){
                int[] p = st.pop();

                if(p!=entrance && (p[0]==0 || p[1]==0 || p[0]==h-1 || p[1]==h-1))
                   return cnt;

                for(int[] d : dirs){
                    int r = p[0] + d[0];
                    int c = p[1] + d[1];

                    if(r>=0 && c>=0 && r<h && c<w && visited[r][c]==false && maze[r][c]=='.'){
                        visited[r][c] = true;
                        st.push(new int[]{r,c});

                    }
                }
            }
            
            
            cnt++;
            
        }
        
        
        return -1;
    }
}