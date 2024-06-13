// https://leetcode.com/problems/palindrome-rearrangement-queries

class Solution {
    public boolean[] canMakePalindromeQueries(String s, int[][] queries) {
        int len = queries.length;
        
        boolean[] res = new boolean[len];
        
        int n = s.length();
        
        
        String left = s.substring(0, n/2);
        String right = new StringBuilder(s.substring(n/2, n)).reverse().toString();
        
        System.out.println(left + " " + right);
        
        int[] arr = new int[26];
        for(int i=0; i<n/2; i++){
            arr[left.charAt(i)-'a']++;
            arr[right.charAt(i)-'a']--;
        }
        
        
        for(int i=0; i<26; i++){
            if(arr[i]!=0) return res;
        }
        
        
        
        for(int i=0; i<len; i++){
            
            if(left.equals(right)){
                res[i]=true;
                continue;
            }
            
            int[] tmp = new int[26];
            // System.arraycopy(arr, 0, tmp, 0, 26);
            
            int[] q = queries[i];
            
            int a = q[0];
            int b = q[1];
            int c = n-q[2]-1;
            int d = n-q[3]-1;
            
            System.out.println(a + " "+b + " " + c + " " + d);
            
            boolean ans = true;
            
//             for(int j=a; j<=b; j++){
//                 tmp[left.charAt(j)-'a']++;
//                 tmp[right.charAt(j)-'a']--;
                
//             }
            
//             for(int j=0; j<26; j++){
//                 // System.out.print(tmp[j]+",");
//                 if(tmp[j]!=0){
//                     ans=false;
//                     System.out.print("AA");
//                     break;
//                 }
//             }
            
             // tmp = new int[26];
          
            
            
             for(int j=0; j<n/2; j++){
                
                if( !(j>=a && j<=b)  && !(j>=d && j<=c)){
                    if(left.charAt(j)!=right.charAt(j)){
                        ans= false;
                          System.out.print("CC");
                        break;
                    }
                }else{
                      
                    tmp[left.charAt(j)-'a']++;
                    tmp[right.charAt(j)-'a']--;


                   
                }
            }
            
             for(int j=0; j<26; j++){
                        if(tmp[j]!=0){
                            ans=false;
                              System.out.print("BB="+ j);
                            break;
                        }
                    }
            
            
            
            res[i]=ans;
            
            
            
            
        }
        
        return res;
        
    }
    /* 
    
    abc 0-2
    cba 0 0
    
    
    
    "bcdbdc"
    
    bcd
    cdb
    
    
    */
    
     
}