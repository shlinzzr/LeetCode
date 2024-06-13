// https://leetcode.com/problems/find-all-anagrams-in-a-string

class Solution {
      public List<Integer> findAnagrams(String s, String p) {
      
          List<Integer> res = new ArrayList<>();
              
          int[] arr = new int[26];
          for(char c : p.toCharArray()){
              arr[c-'a']++;
          }
          
          int start=0;
          for(int end=0; end<s.length(); end++){
              
              char c = s.charAt(end);
              
              // if(arr[c-'a']>0)
              //     t--;
              
              arr[c-'a']--;
                  
                  
                  
              if(end-start+1>p.length()){
                  // if(arr[s.charAt(start)-'a']>0)
                  //   t++;
                  
                  arr[s.charAt(start)-'a']++;
                  start++;
              }
              
             
                  
                  boolean find=true;
                  for(int i=0; i<arr.length; i++){
                       if(arr[i]>0){
                           find=false;
                           break;
                       }
                  }
                  
                  if(find)
                      res.add(start);
          }
          
            return res;
          
      }
    
    
    // TLE
//     public List<Integer> findAnagrams(String s, String p) {
        
//         List<String> perm = new ArrayList<>();
//         getPerm(perm, p, "", new boolean[p.length()]);
        
//         List<Integer> list = new ArrayList<>();
//         int st =0;
        
//         while(st<s.length()-p.length()){
            
//             for(String find : perm){
//                 int idx = s.substring(st).indexOf(find);
//                 if(idx>=0){
//                     list.add(st+idx);

//                     st = st+idx +p.length();

//                 }else{
//                     break;
//                 }
//             }
//         }
//         return list;
//     }
    
//     private void getPerm(List<String> list, String a, String curr, boolean[] used){
                
//         if(curr.length()==a.length())
//             list.add(curr);
        
//         for(int i=0; i<a.length(); i++){
            
//             if(used[i]==false){
//                 used[i]=true;
//                 curr += a.charAt(i);
//                 getPerm(list, a, curr, used);
//                 used[i]=false;
//                 curr = curr.substring(0, curr.length()-1);
//             }
//         }
        
//     }
    
}