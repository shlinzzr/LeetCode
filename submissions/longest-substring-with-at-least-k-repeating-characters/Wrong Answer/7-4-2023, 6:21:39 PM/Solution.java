// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters

class Solution {
    public int longestSubstring(String s, int k) {
        int len = s.length();
        
        int max =0;
        
        int[] arr = new int[26];
        
        int st = k, ed=len;
        
        while(st<ed){
            
            int mid = st+(ed-st+1)/2;
            
            boolean bool = isValid(mid, s, k);
            
            // System.out.println(st + " " + ed +  " " + mid + " b="+bool);
            
            if(bool){
                st = mid;
            }else{
                ed = mid-1;
            }
            
            // System.out.println(st + " " + ed +  " " + mid);
            
        }
        
        return isValid(st, s, k) ?st : -1;
        
        
        
        
//         for(int ed=0; ed<len;ed++){
            
//             arr[s.charAt(ed)-'a']++;
            
//             if(isValid(arr, k)){
//                 max = Math.max(max, ed-st+1);
//             }
            
//         }
    }
    
    
    private boolean isValid(int win, String s, int k){
        
        
        // System.out.println(  "isValid(" + win );
        
        int len = s.length();
        
        // [0 1 2 (3 4)]
        
        int[] arr = new int[26];
        
        
        int st = 0;
        for(int ed=0; ed<len; ed++){
            
            arr[s.charAt(ed)-'a']++;
            
            if(ed-st+1<win)
                continue;
            
            boolean flag=true;
            for(int a: arr){
                if(a!=0 && a<k){
                    flag=false;
                    break;
                }
            }
            
             // System.out.println(  "st=" +st + " ed=" + ed  + " f="+flag);
       
            if(flag)
                return true;
            
            arr[s.charAt(st++)-'a']--;
        }
        
        return false;
        
        
        
        
    }
    
}