// https://leetcode.com/problems/encode-string-with-shortest-length

class Solution {
    public String encode(String s) {
        
        if(s.length()<=4)
            return s;
        
        StringBuilder sb = new StringBuilder();
        
        char[] arr = s.toCharArray();
        
        int con =1;
        StringBuilder curr = new StringBuilder();
        
        // aaaaa
        
        
        for(int i=0; i<s.length()-1; i++){
            
            curr.append(arr[i]);
            
            if(arr[i]==arr[i+1]){
                
                con++;
            }else{
                
                if(con>4){
                    sb.append(con + "["+arr[i]+"]");
                    curr=new StringBuilder();
                    
                }else{
                    sb.append(curr);
                }
                con=1;
            }
        }
        
        if(con>4){
            sb.append(con + "["+arr[arr.length-1]+"]");
        }else{
            sb.append(curr);
        }
        
        
        return sb.toString();
        
        
    }
}