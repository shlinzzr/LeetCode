// https://leetcode.com/problems/filling-bookcase-shelves

class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {

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
}