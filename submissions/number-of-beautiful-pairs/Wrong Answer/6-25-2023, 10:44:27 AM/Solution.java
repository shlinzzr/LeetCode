// https://leetcode.com/problems/number-of-beautiful-pairs

class Solution {
    public int countBeautifulPairs(int[] nums) {
        
        HashSet<String> set = new HashSet<>();
        
        int len = nums.length;
        int cnt =0;
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                
                int x = firstDigit(nums[i]);
                int y = firstDigit(nums[j]);
                
                
                if(gcd(x, y)==1){
                    
                    if(x>=y)
                    
                        set.add(x+"_"+y);

                    else 
                        set.add(y+"_"+x);
                    
                    
                    // System.out.println(x+ " " + y);
                }
                    
            }
            
            
        }
        
        return set.size();
    }
    
    
    
    private int gcd(int a, int b){
        
        if(b==0) return a;
        return gcd(b, a%b);
        
    }
    
    private int firstDigit(int x){
        
        String s = String.valueOf(x);
        return s.charAt(0)-'0';
        
    }
        
}