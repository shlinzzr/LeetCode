// https://leetcode.com/problems/candy-crush

class Solution {
    public int[][] candyCrush(int[][] board) {
        int h = board.length;
        int w = board[0].length;
        
        if(w>h){
            int[][] tmp = new int[w][h];
            for(int i=0; i<h;i++){
                for(int j=0; j<w; j++){
                    board[i][j] = tmp[j][i];
                }
            }
            return candyCrush(tmp);
        }        

        
        boolean stable = true;
        
        int[][] tmp = new int[h][w];
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                tmp[i][j]=board[i][j];
            }
        }
        
        // find expo
        for(int i=0; i<h-2; i++){
            for(int j=0; j<w; j++){
                if(board[i][j]!=0 && board[i][j]==board[i+1][j] && board[i+1][j]==board[i+2][j]){
                    tmp[i][j]=0;
                    tmp[i+1][j]=0;
                    tmp[i+2][j]=0;
                    stable=false;
                }
                
                
            }
        }
       
        for(int j=0; j<w-2; j++){
            for(int i=0; i<h; i++){
                
                if(board[i][j]!=0 && board[i][j]==board[i][j+1] && board[i][j+1]==board[i][j+2]){
                    
                    tmp[i][j]=0;
                    tmp[i][j+1]=0;
                    tmp[i][j+2]=0;
                    stable=false;
                }
            }
        }
        
         board = tmp;
        
//         for(int i=0; i<h;i++){
//             for(int j=0; j<w; j++){
//                 System.out.print(tmp[i][j] +", ");
//             }
//             System.out.println();
//         }
        
//         System.out.println();
        
        
        
        if(stable)
            return board;
        
        clean(board);
        return candyCrush(board);
    }
    
    /*
    [[110, 5,  112,113, 114]
    ,[210, 211, 5, 213, 214]
    ,[310, 311, 3, 313, 314]
    ,[410, 411, 412,5, 414]
    ,[5,    1,  512, 3,  3]
    ,[610,  4,  1,  613,614]
    ,[710,  1,  2,  713,714]
    ,[810,  1,  2,  1,   1]
    ,[1,    1,  2,  2,  2]
    ,[4,    1,  4,  4, 1014]]*/
    
    
    private void clean(int[][] board){
        
        int h = board.length;
        int w = board[0].length;
        
        for(int j=0; j<w;j++){
        
            int idx = h-1;
            for(int i=h-1; i>=0; i--){
                
                if(board[i][j]!=0){
                    board[idx][j]=board[i][j];
                    idx--;
                }
            }
            
            while(idx>=0){
                board[idx][j]=0;
                idx--;
            }
        }
    }
}