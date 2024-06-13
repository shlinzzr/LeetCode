// https://leetcode.com/problems/confusing-number-ii

class Solution {
    
     Set<Integer> set ;
    
    public int confusingNumberII(int n) {
        int[] mapping = new int[]{0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
        
        set = new HashSet<>(Arrays.asList(0,1,6,8,9));
        
        int cnt = 0;
        for(int i=1; i<=n; i++){
            
            if(isConfusing(i) && i!=1 && i!=8 && i%11!=0){
                // System.out.println(i);
                cnt++;
            }
                
            
        }   
        
        return cnt;
    }
    
    private boolean isConfusing(int n){
        
        String s = String.valueOf(n);
        for(char ch : s.toCharArray()){
            if(set.contains(ch-'0'))
                continue;
            return false;
        }
        return true;
        
    }
    
}