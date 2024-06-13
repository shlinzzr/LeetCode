// https://leetcode.com/problems/sum-of-matrix-after-queries

class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        long row=n,col=n;
        long sum=0;
        HashSet<Integer> rowMap=new HashSet<>();
        HashSet<Integer> colMap=new HashSet<>();
        for(int i=queries.length-1;i>=0;i--){
            if(queries[i][0]==0){
                if(col<=0||rowMap.contains(queries[i][1]))continue;
                sum+=(col)*(long)queries[i][2];
                rowMap.add(queries[i][1]);
                row--;
            }else{
                if(row<=0||colMap.contains(queries[i][1]))continue;
                sum+=(row)*(long)queries[i][2];
                colMap.add(queries[i][1]);
                col--;
            }
        }
        return sum;
    }
}