// https://leetcode.com/problems/number-of-provinces

class Solution {
    boolean[]visited;
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        visited = new boolean[m];
        
        int provinces = 0;
        for(int i=0;i<m;i++) {
            if(!visited[i]) {
                dfs(i, isConnected);
                provinces++;
            }
        }
        return provinces;
    }
    
    void dfs(int i, int[][] connectedNodes) {
        visited[i] = true;
        int[] connectedNode = connectedNodes[i];
        for(int j=0;j<connectedNode.length;j++) {
            if(i!=j && !visited[j] && connectedNodes[i][j]==1)
                dfs(j, connectedNodes);
        }
        
    } 
}