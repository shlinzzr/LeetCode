// https://leetcode.com/problems/design-tic-tac-toe

class TicTacToe {

    int[][] mat;
    int n ;
    
    public TicTacToe(int n) {
        mat = new int[n][n];
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        
        mat[row][col]=player;
        
        return checkWin();
    }
    
    private int checkWin(){
//         System.out.println("check");
//         for(int i=0; i<n; i++){
//             for(int j=0; j<n; j++){
//                 System.out.print(mat[i][j]+",");
//             }
//             System.out.println();
//         }
        
        boolean revDia = true;
        boolean allDia = true;
        int diaHead = mat[0][0];
        int revHead = mat[0][n-1];
        
        for(int i=0; i<n; i++){
            
            if(mat[i][i]!=diaHead)
                allDia=false;
            
             if(mat[i][n-i-1]!=revHead)
                revDia=false;
            
            
            boolean allRow = true;
            boolean allCol = true;
            
            int rowHead = mat[i][0];
            int colHead = mat[0][i];
            for(int j=0; j<n; j++){
                
                if(mat[i][j]!=rowHead)
                    allRow = false;
                
                if(mat[j][i]!=colHead)
                    allCol = false;
            }
            
            if(allRow)
                return rowHead;
            
            if(allCol)
                return colHead;
            
        }
       
        
         if(allDia)
            return diaHead;
        
         if(revDia)
            return revHead;
        
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */