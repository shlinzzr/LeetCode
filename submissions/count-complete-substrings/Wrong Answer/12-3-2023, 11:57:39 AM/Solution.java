// https://leetcode.com/problems/count-complete-substrings

class Solution {
    public int countCompleteSubstrings(String word, int k) {
        
        List<String> list = buildList(word, k);
        
        System.out.println(list.size());
        int res = 0;
        for(String w : list){
            int[] arr = new int[26];
            int len = w.length();
            int st =0;
            for(int i=0; i<len; i++){
                
                arr[w.charAt(i)-'a']++;
                if(isKtimes(arr, k)==-1){
                    continue;
                }
                
                while(st<len && isKtimes(arr, k)==1){
                    arr[w.charAt(st)-'a']--;
                    st++;
                }
                
                if( isKtimes(arr, k) ==0){
                         System.out.println(w.substring(st, i+1));
                    res++;
                }
            }
            
            while(st<len-1){
                   arr[w.charAt(st)-'a']--;
                 st++;
                    if( isKtimes(arr, k) ==0){
                  
                         System.out.println(w.substring(st, len));
                        res++;
                    }
               
            }
        }
        
        
      
        return res;
    }
    
    private List<String> buildList(String word, int k){
         List<String> list = new ArrayList<>();
        int len = word.length();
        
        int st=0;
        for(int i=0; i<len-1;i++){
            
            if(word.charAt(i+1)-word.charAt(i)>2){
                list.add(word.substring(st, i+1));
                st=i+1;
            }
        }
        
        if(st==len-1)
            list.add(word.substring(len-1, len));
        else if (st==0)
            list.add(word);
        
        return list;
    }
    
    
    private int isKtimes(int[] arr, int k){
        
        for(int i=0; i<26; i++){
            if(arr[i]!=0 && arr[i]>k)
                return 1;
            if(arr[i]!=0 && arr[i]<k)
                return -1;
        }
        
        return 0;
    }
    
}