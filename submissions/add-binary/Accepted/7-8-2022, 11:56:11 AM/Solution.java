// https://leetcode.com/problems/add-binary

class Solution {
    public String addBinary(String a, String b) {
        
        int siz = Math.min(a.length(), b.length());
        
        String res="";
        
        char jinway = '0';
        
        for(int i=0; i<siz; i++){
            
            char ca = a.charAt(a.length()-i-1);
            char cb = b.charAt(b.length()-i-1);
            
            char c = '1';
            
            if(ca=='0' && cb=='0' && jinway=='0'){
                c= '0';
                jinway='0';
                
            }else if( ca=='0' && cb=='0' && jinway=='1'
                   || ca=='0' && cb=='1' && jinway=='0'
                   || ca=='1' && cb=='0' && jinway=='0'){
                c='1';
                 jinway='0';
                    
            }else if( ca=='0' && cb=='1' && jinway=='1'
                   || ca=='1' && cb=='0' && jinway=='1'
                   || ca=='1' && cb=='1' && jinway=='0'){
                c='0';
                jinway='1';
                
            }else if( ca=='1' && cb=='1' && jinway=='1'){
                c='1';
                jinway='1';
            }
            
            res = c + res;
            System.out.println(ca +", " + cb + ", " + res);
        }
        
        
        for(int i=siz; i<a.length(); i++){
            
            char ca = a.charAt(a.length()-i-1);
            if(ca=='1' && jinway=='1'){
                ca = '0';
                
            }else if(ca=='0'&& jinway=='1'){
                ca='1';
                jinway='0';
            }
            
            res = ca + res;    
        }
        
        for(int i=siz; i<b.length(); i++){
            
            char cb = b.charAt(b.length()-i-1);
            if(cb=='1' && jinway=='1'){
                cb = '0';
                
            }else if(cb=='0'&& jinway=='1'){
                cb='1';
                jinway='0';
            }
            
            res = cb + res;    
            
        }
        
        if(jinway=='1')
            res = '1'+res;
        
        
        
        return res;
        
    }
}