// https://leetcode.com/problems/shortest-path-to-get-all-keys

class Solution {
    public int shortestPathAllKeys(String[] grid) {

        int h = grid.length;
        int w = grid[0].length();
        
        Queue<int[]> queue = new LinkedList<>();
        
        int lock = 0;
        
        int[] start = new int[3]; // r, c, curr keys
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                char ch = grid[i].charAt(j);
                if(ch=='@'){
                    start[0]=i;
                    start[1]=j;
                }else if(ch>='A' && ch<='F'){
                    lock |= (1<<(ch-'A'));
                }
            }
        }
        
        queue.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(start[0] + " " + start[1] + " " + start[2]);

        int step = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] p = queue.poll();
                
                for (int[] d : dirs) {
                    int i = p[0] + d[0];
                    int j = p[1] + d[1];
                    int keys = p[2];
                    
                    if (i < 0 || i >= h || j < 0 || j >= w) continue;                   // out of grid
                    char ch = grid[i].charAt(j);

                    if (ch == '#') continue;                                             // wall
                    if ('A' <= ch && ch <= 'F' && ((p[2] >> (ch-'A')) & 1) == 0) continue; // meet lock without key = wall
                    if ('a' <= ch && ch <= 'f') keys = p[2] | (1 << (ch-'a'));             // update key
                    if (visited.contains(i + " " + j + " " + keys)) continue;           // visited
                    if (keys == lock) return step+1;                                   // all found !!!
                    visited.add(i + " " + j + " " + keys );
                    queue.offer(new int[] {i, j, keys});
                }
            }
            step++;
        }

        return -1; // not found
    }
}