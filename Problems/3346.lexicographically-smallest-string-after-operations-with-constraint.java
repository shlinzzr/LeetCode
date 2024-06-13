// https://leetcode.com/problems/lexicographically-smallest-string-after-operations-with-constraint

class Solution {
    public String getSmallestString(String s, int k) {
        
        
        String org = s; 
        
        char[] arr = s.toCharArray();
        
    
        
        // System.out.println(dis("aa", "zz"));。
        
        int idx = 0;
        while(k>0 && idx<s.length()){
            if(arr[idx]=='a'){
                idx++;
                continue;
            }
            
            
            
            
            
            char ch = arr[idx];
            
            int d = getDis(ch+"", "a");
            
            if(k>=d){
                arr[idx]='a';
                k -= d;
            }else{
                arr[idx]-=k;
                k=0;
            }
                
            
            
            
            
//             if('z'-ch+1 >  ch-'a' )
            
            
//             if(arr[idx]-'a'>=k){
                
//                 arr[idx]-=k;
//                 k=0;
//             }else{
                
//                 k-=arr[idx]-'a';
//                 arr[idx]='a';
//             }
            idx++;
            
        }
        
        return new String(arr);
        
    }
    
    private int getDis(String a , String b){
        
        int res = 0;
        
        for(int i=0; i<a.length(); i++){
            char ca = a.charAt(i);
            char cb = b.charAt(i);
            
            if(ca>cb){
                
                int val = ca-cb;
                if(val>13)
                    val=26-val;
                res+=val;
                
            }
               
            else {
                    
                int val = cb-ca;
                // System.out.println(val);
                if(val>13)
                    val=26-val;
                res+=val;
            }
        }
        
        return res;
        
    }
}