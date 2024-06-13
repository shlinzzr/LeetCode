// https://leetcode.com/problems/add-binary

class Solution {
    public String addBinary(String a, String b) {
        
        
        int idx_a = a.length()-1;
        int idx_b = b.length()-1;
        
        int carry = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while(idx_a>=0 && idx_b>=0){
            
            char ca = a.charAt(idx_a);
            char cb = b.charAt(idx_b);
            
            if(ca!=cb){
                if(carry==1){
                    sb.insert(0, "0");
                    carry=1;
                }
                else 
                    sb.insert(0, "1");
                
            }else{ //ca==cb
                if(ca=='1'){
                    if(carry==1){
                        sb.insert(0, "1");
                        carry=1;
                    }
                    else{
                        sb.insert(0, "0");
                        carry=1;
                    }
                    
                }else{
                    if(carry==1){
                        sb.insert(0, "1");
                        carry=0;
                    }else{
                        sb.insert(0, "0");
                    }
                }
            }
            idx_a--;
            idx_b--;
            
            // System.out.println(sb.toString() + " " + carry);
        }
        
        while(idx_a>=0){
            char ca = a.charAt(idx_a);
            
            if(ca=='1'){
                
                if(carry==1){
                    sb.insert(0, "0");
                }else{
                    sb.insert(0, "1");
                    carry=0;
                }
            }else{
                
                if(carry==1){
                    sb.insert(0, "1");
                    carry=0;
                }else{
                    sb.insert(0, "0");
                }
            }
            // System.out.println(sb.toString());
            
            idx_a--;
        }
        
        while(idx_b>=0){
            char cb = b.charAt(idx_b);
            
            if(cb=='1'){
                
                if(carry==1){
                    sb.insert(0, "0");
                }else{
                    sb.insert(0, "1");
                    carry=0;
                }
            }else{
                
                if(carry==1){
                    sb.insert(0, "1");
                    carry=0;
                }else{
                    sb.insert(0, "0");
                }
            }
            // System.out.println(sb.toString());
            
            idx_b--;
        }
        
        if(carry==1)
          sb.insert(0, "1");
        
        
        return sb.toString();
        
        
        
    }
}