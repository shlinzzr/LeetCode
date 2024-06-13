// https://leetcode.com/problems/palindrome-rearrangement-queries

class Solution {
    public boolean[] canMakePalindromeQueries(String s, int[][] queries) {
        int len = queries.length;
        
        boolean[] res = new boolean[len];
        
        int n = s.length();
        
        
        String left = s.substring(0, n/2);
        String right = new StringBuilder(s.substring(n/2, n)).reverse().toString();
        
        // System.out.println(left + " " + right);
        
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
            System.arraycopy(arr, 0, tmp, 0, 26);
            
            int[] q = queries[i];
            
            int a = q[0];
            int b = q[1];
            int c = n-q[2]-n/2;
            int d = n-q[3]-n/2;
            
            for(int j=0; j<n/2; j++){
                
                if( !(j>=a && j<=b)  && !(j>=d && j<=c)){
                    if(left.charAt(j)!=right.charAt(j)){
                        break;
                    }
                    tmp[left.charAt(j)-'a']--;
                    tmp[right.charAt(j)-'a']++;
                }
                
            }
            
            for(int j=0; j<26; j++){
                if(tmp[j]!=0){
                    break;
                }
            }
            
            res[i]=true;
            
            
            
            
        }
        
        return res;
        
    }
    
    
     
}