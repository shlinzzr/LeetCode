// https://leetcode.com/problems/strange-printer-ii

class Solution {
    
    int[][] posMin = new int[61][2];//Up Left
    int[][] posMax = new int[61][2];//Down Right
    
    public boolean isPrintable(int[][] targetGrid) {
        
        for(int[] row:posMin){
            Arrays.fill(row,61);
        }
        
        for(int[] row:posMax){
            Arrays.fill(row,0);
        }
        
        int m = targetGrid.length;
        int n = targetGrid[0].length;
        HashSet<Integer> colorSet = new HashSet<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int c = targetGrid[i][j];
                colorSet.add(c);
                posMin[c][0] = Math.min(posMin[c][0],i);//Up
                posMin[c][1] = Math.min(posMin[c][1],j);//Left
                posMax[c][0] = Math.max(posMax[c][0],i);//Down
                posMax[c][1] = Math.max(posMax[c][1],j);//Right
            }
        }
        while(colorSet.size()>0){
            HashSet<Integer> tmp = new HashSet<>();
            for(int color:colorSet){
                if(!isRect(targetGrid,color)){
                    tmp.add(color);
                }
            }

            if(tmp.size()==colorSet.size())
                return false;
            colorSet = tmp;
        }
        
        return true;
    }
    
    private boolean isRect(int[][] A,int c){
        for(int i=posMin[c][0];i<=posMax[c][0];i++){
            for(int j=posMin[c][1];j<=posMax[c][1];j++){
                if(A[i][j] > 0 && A[i][j] != c)
                    return false;
            }
        }
        
        for(int i=posMin[c][0];i<=posMax[c][0];i++){
            for(int j=posMin[c][1];j<=posMax[c][1];j++){
                A[i][j] = 0;
            }   
        }
        
        return true;
    }
}