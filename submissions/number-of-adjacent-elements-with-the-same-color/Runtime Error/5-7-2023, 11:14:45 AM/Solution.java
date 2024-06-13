// https://leetcode.com/problems/number-of-adjacent-elements-with-the-same-color

class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        
        int len = queries.length;
        
        int[] curr = new int[len];
        int[] res =  new int[len];
        int cnt =0;
        
        for(int i=0; i<len; i++){
            
            int index = queries[i][0];
            int color = queries[i][1];
            
            if(index-1>=0 && curr[index-1]==curr[index] && curr[index]!=0)
                cnt--;
            
            if(index+1<len && curr[index+1]==curr[index] && curr[index]!=0)
                cnt--;
            
            
            
            curr[index]=color;
            
            if(index-1>=0 && curr[index-1]==color)
                cnt++;
            
            if(index+1<len && curr[index+1]==color)
                cnt++;
            
            res[i]=cnt;
        }
        
        return res;
    }
}