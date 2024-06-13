// https://leetcode.com/problems/design-tic-tac-toe

class TicTacToe {
    int[] row;
    int[] col;
    int diagonal = 0;
    int anti_diagonal=0;
    int n;
    public TicTacToe(int n) {
        row = new int[n];
        col = new int[n];
        this.n=n;
    }
    
    public int move(int i, int j, int player) {
        
        int toAdd = player == 1 ? 1 : -1;

        row[i]+=toAdd;
        col[j]+=toAdd;

        if(i==j) diagonal+=toAdd;
        if(i==n-j-1) anti_diagonal+=toAdd;


        if(row[i]==n || col[j]==n || anti_diagonal==n || diagonal==n) return 1;
        if(row[i]==-n || col[j]==-n || anti_diagonal==-n || diagonal==-n) return 2;
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */