// https://leetcode.com/problems/ugly-number-ii

class Solution {
    public int nthUglyNumber(int n) {
        
        List<Integer> list = new ArrayList<>();
        
        int i=0;
        
        while(n>0){
            i++;
            
            boolean ugly = true;
            for(int p : list){
                if(i%p==0)
                    ugly=false;
            }
            
            
            if(ugly==true && (i==1 || i%2==0 || i%3==0 || i%5==0)){
                n--;    
            }else{
                list.add(i);
            }
        }
        
        return i;
        
    }
}