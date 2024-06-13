// https://leetcode.com/problems/find-all-anagrams-in-a-string

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        
        int st = 0;
        int[] arr = new int[26];
        
        for(char c : p.toCharArray()){
            arr[c-'a']++;
        }
        
        
        int cnt=0;
        for(int ed=0; ed<s.length(); ed++){
            
            arr[s.charAt(ed)-'a']--;
            
              if(ed-st+1>p.length()){
                  arr[s.charAt(st)-'a']++;
                  st++;
              }
              
           
              
              boolean find=true;
              for(int i : arr){
                  if(i>0){
                      find=false;
                      break;
                  }
              }
              
              if(find)
                  res.add(st);
            
            
            // if(arr[s.charAt(ed)-'a']>0)
            //     cnt++;
            
//             if(cnt==p.length()){
//                 if(isAna(s.substring(st, ed+1), p))
//                     res.add(st);
//             }
            
//             if(ed-st+1==p.length()){
//                 // System.out.println("ed="+ed+ " st="+st );
//                 if(arr[s.charAt(st)-'a']>0)
//                     cnt--;
                
//                 st++;
                
//             }
                
                
            
            
        }
            
        return res;
        
    }
    
    
    private boolean isAna(String s, String p){
        
        int[] tmp = new int[26];
        
        
        for(char c : p.toCharArray()){
            tmp[c-'a']++;
        }
        
        
        for(char c : s.toCharArray()){
            tmp[c-'a']--;
        }
        
        
        for(int t : tmp)
            if(t!=0)
                return false;
        return true;
    }
    
}