// https://leetcode.com/problems/interval-list-intersections

class Solution {
    public int[][] intervalIntersection(int[][] F, int[][] S) {
        List<List<Integer>> res = new ArrayList<>();
        
        int len1 = F.length;
        int len2 = S.length;
        if(len1==0 || len2==0)
            return new int[0][0];
        
        
        int idx1 = 0, idx2=0;
        
        while(idx1<len1 && idx2<len2 ){
            
            int[] f = F[idx1];
            int[] s = S[idx2];
            
            if(f[1]<s[0] || s[1]<f[0]){
                
                if(f[1]<s[0])
                    idx1++;
                else 
                    idx2++;
                
                continue;
            }else{
                
                int st = Math.max(f[0], s[0]);
                int ed = Math.min(f[1], s[1]);
                res.add(Arrays.asList(st, ed));
                
                if(f[1]==s[1]){
                    idx1++;
                    idx2++;
                }else if(f[1]<s[1])
                    idx1++;
                else 
                    idx2++;
            }
        }
        
        
        int[][] ret = new int[res.size()][2];
        for(int i=0; i<res.size(); i++){
            ret[i][0] = res.get(i).get(0);
            ret[i][1] = res.get(i).get(1);
        }
        
        return ret;
        
    }
}