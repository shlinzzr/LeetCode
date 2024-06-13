// https://leetcode.com/problems/self-dividing-numbers

class Solution {
   
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for(int i = left; i <= right; i++)
            if(isSelfDividing(i))
                list.add(i);
        
        return list;
    }
    
    
     private boolean isSelfDividing(int n){
        for(char c: String.valueOf(n).toCharArray())
            if(c == '0' || (n % (c - '0') > 0))
                return false;
        return true;
    }
    
}