// https://leetcode.com/problems/filling-bookcase-shelves

class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        
        // int[][] dp // let dp be the min height of total shelf with checking the first i book with using j book
        int len = books.length;        

        int[] dp = new int[len+1];

        for(int i=1; i<=len; i++){
            int width = books[i-1][0];
            int height = books[i-1][1];
            dp[i] = dp[i-1] + height;
            for(int j=i-1; j>0 && width+books[j-1][0] <= shelfWidth; j--){
                height = Math.max(height, books[j-1][1]);
                width += books[j-1][0];
                dp[i] = Math.min(dp[i], dp[j-1]+height);
            }
        }

        return dp[len];
        
    }
    
    
    
//     public int minHeightShelves(int[][] books, int shelfWidth) {
//         int len = books.length;
        
//         Arrays.sort(books, (a,b)-> a[1]-b[1]);
        
//         int res = 0;
        
//         for(int i=0; i<len; i++){
            
//             int w = 0;
//             int h = 0;
//             while(w<shelfWidth && i<len){
//                 int[] b = books[i];
//                 int thick = b[0];
//                 int height = b[1];    
                
//                 if(w+thick<=shelfWidth){
//                     w+= thick;
//                     h = Math.max(h, height);
//                 }
//                 i++;
//             }
//             i--;            
//             res+=h;
//             System.out.println(h + " " + i);
//         }
        
//         return res;
//     }
}