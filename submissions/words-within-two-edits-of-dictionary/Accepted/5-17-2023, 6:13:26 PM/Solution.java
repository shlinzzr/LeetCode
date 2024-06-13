// https://leetcode.com/problems/words-within-two-edits-of-dictionary

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        
        List<int[]> list1 = new ArrayList<>();
        for(int i=0; i<queries.length; i++){
            String q = queries[i];
            int[] arr = new int[26];
            
            for(char ch : q.toCharArray()){
                arr[ch-'a']++;
            }
            list1.add(arr);
        }
            
        List<int[]> list2 = new ArrayList<>();
        for(int j=0; j<dictionary.length; j++){
            String d = dictionary[j];
            int[] arr = new int[26];
            
            for(char ch : d.toCharArray()){
                arr[ch-'a']++;
            }
            list2.add(arr);
        }
        
        
        int wordLen = queries[0].length();
        
        
        
        
        LinkedHashSet<String> set = new LinkedHashSet<>();
        
         for(int i=0; i<queries.length; i++){
             
             for(int j=0; j<dictionary.length; j++){
                 
                 
                 int cnt =0;
                 boolean flag = true;
                 for(int k=0; k<wordLen; k++){
            
                     String q=queries[i];
                     String d=dictionary[j];
                     if(q.charAt(k)!=d.charAt(k))
                         cnt++;
                     if(cnt>2){
                         flag=false;
                         break;
                     }
                     
                  }
                 
                 
                 if(flag){
                     res.add(queries[i]);
                     break;
                 }
                     
                 
                 
                 
//                  int[] arr1= list1.get(i);
//                  int[] arr2= list2.get(j);
                 
//                  int cnt=0;
//                  int diff = 0;
//                  boolean flag=true;
//                  for(int a=0; a<26;a++){
//                     if(arr1[a]!=arr2[a])
//                         cnt++;
//                     diff+=Math.abs(arr1[a]-arr2[a]);
//                     if(diff>4 || cnt>2){
//                         flag=false;
//                         break;
//                     }
                     
//                      if(flag==true){
//                          System.out.println(queries[i] + " " + dictionary[j] + " " + diff);
                         
//                          set.add(queries[i]);
//                          break;
//                      }
//                  }
             }
         }
        
        return res;
        
            
    }
}