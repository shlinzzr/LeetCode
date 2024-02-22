// https://leetcode.com/problems/count-symmetric-integers

class Solution {
public  int countSymmetricIntegers(int low, int high) {
        int cnt = 0;
        for(int i=low; i<=high; i++){
            
//             int tmp=i;
            
//             int rev = 0;
//             while(tmp>0){
//                 rev = rev*10 + tmp%10;
//                 tmp/=10;
//             }
//             if(rev==i&&rev/10 >0){
//                   cnt++;
//                 System.out.println(i+ " "+rev);
//             }
            
            if(isSym(i)){
                 // System.out.println(i);
                 cnt++;
            }
               
              
            
        }
        return cnt;
            
    }
    
    private boolean isSym(int n){
        
        int cnt = 0;
        String s = String.valueOf(n);
        if(s.length()%2==1 || s.length()<2)
            return false;
        
        
        int len = s.length();
        for(int i=0; i<s.length(); i++){

            if(i<len/2)
                cnt+= s.charAt(i)-'0';
            else 
                cnt-= s.charAt(i)-'0';
        }
        
        return cnt==0;
        
        
    }
}