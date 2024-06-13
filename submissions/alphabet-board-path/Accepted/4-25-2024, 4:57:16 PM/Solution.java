// https://leetcode.com/problems/alphabet-board-path

class Solution {
    
     public String alphabetBoardPath(String target) {
         
         int idx= 0 ;
         int len = target.length();
         
         char ch = 'a';
         int curx = 0, cury=0;
         StringBuilder sb = new StringBuilder();
         while(idx<len){
             
             curx = (int)(ch-'a') % 5;
             cury = (int)(ch-'a') / 5;
             
             char dest = target.charAt(idx);
             int destx = (int)(dest-'a') % 5;
             int desty = (int)(dest-'a') / 5;
             
             if(ch==dest){
                 sb.append('!');
                 idx++;
                 continue;
             }
             
             
             if(ch=='z'){ // go y-axis first
                
                 for(int i=0; i<Math.abs(cury-desty); i++){
                    sb.append( (desty>cury ? 'D' : 'U'));
                 }
                 
                 for(int j=0; j<Math.abs(curx-destx); j++){
                    sb.append( (destx>curx ? 'R' : 'L'));
                 }    
                 
             }else{
                for(int j=0; j<Math.abs(curx-destx); j++){
                    sb.append( (destx>curx ? 'R' : 'L'));
                }    
                 
                for(int i=0; i<Math.abs(cury-desty); i++){
                    sb.append( (desty>cury ? 'D' : 'U'));
                }
              
             }
             
             ch = dest;
         }
         return sb.toString();
         
         
     }
    
    
//     public String alphabetBoardPath(String target) {
        
//         StringBuilder sb = new StringBuilder();
//         int h = 6, w=5;
//         char[][] mat = new char[6][5];
//         char ch = 'a';
//         for(int i=0; i<6; i++){
//             for(int j=0; j<5; j++){
//                 mat[i][j] = (ch++);
                
//                 if(i==5 && j==0) break;
//             }
//         }

        
//         int[][] dirs = new int[][]{{1,0}, {0,1},{-1,0}, {0,-1}};
        
//         int idx= 0;
//         boolean[][] seen;
//         resetSeen(seen);
        
//         Queue<int[]> q = new LinkedList<>();
//         q.offer(new int[]{0,0});
//         while(idx<target.length()){
            
//             int[] p = pq.poll();
//             if( mat[p[0]][p[1]] == target.charAt(idx) ){
//                 idx++;
//                 sb.append(mat[p[0]][p[1]]);
//                 resetSeen(seen);
//                 if(idx==target.length()) return sb.toString();
//             }
            
//             for(int[] d : dirs){
//                 int r = d[0] + p[0];
//                 int c = d[1] + p[1];
//                 if(r<0 || c<0 || r>=h || c>=w || seen[r][c]) continue;
                
//                 seen[r][c] = true;
//                 q.offer(new int[]{r,c});
                
//             }
            
            
            
            
//         }
        
        
        
        
//     }
    
//     private void resetSeen(int[][] seen){
        
//         seen[][] = new boolean[5][6];
//         for(int j=1; j<5; j++){
//             seen[5][j] = false;
//         }
//     }
}