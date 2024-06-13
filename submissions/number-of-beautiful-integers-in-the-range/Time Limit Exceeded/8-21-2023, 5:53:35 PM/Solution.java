// https://leetcode.com/problems/number-of-beautiful-integers-in-the-range

class Solution {
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        
        int res = 0;
        
        for(int i=low; i<=high; i++){
            
            if(cond1(i) && i%k==0){
                res++;
            }
            
        }
        
        return res;
    }
    
    private boolean cond1(int num){
        
        int even=0, odd=0;
        
        String s = String.valueOf(num);
        for(char ch : s.toCharArray()){
            if((ch-'0')%2==0)
                even++;
            else 
                odd++;
        }
        
        
        
        return odd==even;
    }
}