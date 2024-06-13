// https://leetcode.com/problems/self-dividing-numbers

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=left; i<=right; i++){
            
            int cur = i;
            
            boolean sd = true;
            while(cur>0){
                int d = cur %10;
                if(d==0 || i%d!=0){
                    sd = false;
                    break;
                }
                cur/=10;
            }
            
            if(sd)
                list.add(i);
        }
        
        return list;
    }
}