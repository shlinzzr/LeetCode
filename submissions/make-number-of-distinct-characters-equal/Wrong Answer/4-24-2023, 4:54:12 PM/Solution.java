// https://leetcode.com/problems/make-number-of-distinct-characters-equal

class Solution {
    public boolean isItPossible(String word1, String word2) {
        
        int len1= word1.length();
        int len2= word2.length();
        int dis1 = 0, dis2=0;
        
        // HashMap<Character, Integer> map1 = new HashMap();
        // HashMap<Character, Integer> map2 = new HashMap();
        
        
        int[] arr1 = new int[26];
        for(char ch : word1.toCharArray()){
            if(arr1[ch-'a']==0)
                dis1++;
            arr1[ch-'a']++;
            
            // map1.put(ch, map1.getOrDefault(ch, 0)+1);
        }
        
        int[] arr2 = new int[26];
        for(char ch : word2.toCharArray()){
            if(arr2[ch-'a']==0)
                dis2++;
            arr2[ch-'a']++;
            // map2.put(ch, map2.getOrDefault(ch, 0)+1);
        }
        
        int abs = Math.abs(dis1-dis2);
        if(abs>2)
           return false;
        
        if(dis1==dis2) //aaab , ba
           return true;
        
        boolean iToj = (dis1>dis2)? true: false;
           
                           
        if(iToj==false){
            int[] tmp = new int[26];
            tmp = arr1;
            arr1=arr2;
            arr2=tmp;
        }
        
           
        for(int i=0; i<26; i++){
            
            for(int j=0; j<26; j++){
                
                if(abs==1){
                    if(arr1[i]>1 && arr2[j]==0)
                        return true;
                    
                    if(arr1[i]==1 && arr2[j]>0)
                        return true;
                }else if(abs==2){
                    if(arr1[i]==1 && arr1[j]>0 && arr2[j]==0)
                        return true;
                }
            }
            
        }
           
           return false;
        
    }
           
           
    /* 
    
    distinct有幾種狀況
    多的b換到少的a:
    
    x. b exist 換到a exist : no chg
    0   b exist 換到a no exist : a+1
    1  b(unique)換到a(exist) : b-1;
    2. b unique 換到 a no exist : b-1, a+1
    
    
    
    */
           
}