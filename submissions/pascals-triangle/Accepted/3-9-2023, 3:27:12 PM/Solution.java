// https://leetcode.com/problems/pascals-triangle

class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>>  res = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            
            if(res.size()<i+1)
                res.add(new ArrayList<>());
            
            for(int j=0; j<=i; j++){
                
                if(j==0 || j==i){
                    res.get(i).add(1);
                    continue;
                }
                
                int num = res.get(i-1).get(j)+ res.get(i-1).get(j-1);
                res.get(i).add(num);
                    
            }
        }
        
        return res;
    }
}