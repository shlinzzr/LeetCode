// https://leetcode.com/problems/the-maze-ii

class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // directions to top, bottom, left and right
        int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
        // record shotest distance
        int[][] arr =new int[maze.length][maze[0].length];
        // Set all cell as -1
        for(int[] a: arr){
            Arrays.fill(a,-1);
        }
        // Initialize start distance to 0
        arr[start[0]][start[1]]=0;
        Queue<int[]> q=new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            
            int[] p=q.poll();

            for(int[] dir : dirs){

                int dis = arr[p[0]][p[1]];
                int y=p[0];
                int x=p[1];

                while(y+dir[0]>=0 && y+dir[0]<maze.length 
                   && x+dir[1]>=0 && x+dir[1]<maze[0].length
                   && maze[y+dir[0]][x+dir[1]]!=1){
                    y+=dir[0];
                    x+=dir[1];
                    dis++;
                }
                // If this cell is first time to reach or the distance to this cell is shorter
                // add it to queue and update distance
                if(arr[y][x]==-1|| arr[y][x]>dis){
                    q.add(new int[]{y,x});
                    arr[y][x]=dis;
                }
            }
        }
        return arr[destination[0]][destination[1]];
    }
}