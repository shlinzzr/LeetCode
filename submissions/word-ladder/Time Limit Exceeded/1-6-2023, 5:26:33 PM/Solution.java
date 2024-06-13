// https://leetcode.com/problems/word-ladder

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord))
            return 0;
        
        
        HashMap<String, Set<String>> map = new HashMap<>();
        findNeb(beginWord, wordSet, map);
        for(String w : wordSet){
            findNeb(w, wordSet, map);
        }
        
        // for(Map.Entry<String, Set<String>> en : map.entrySet()){
        //     System.out.println(en.getKey()+ " " + en.getValue());
        // }
        
        
        
        HashSet<String> seen = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        seen.add(beginWord);
        int step=1;
        while(!q.isEmpty()){
            step++;
            
            for(int i=q.size(); i>0; i--){
                
                String p = q.poll();
                Set<String> nebs = map.get(p);
                if(nebs.contains(endWord))
                    return step;
                
                
                for(String n : nebs){
                    if(seen.contains(n))
                        continue;
                         
                   
                    
                    seen.add(n);
                    q.offer(n);
                }
            }
            // System.out.println(step +" " + seen);
            
        }
        
        return 0;
        
        
    }
    
     private void findNeb(String s, Set<String> wordSet, HashMap<String, Set<String>> map){
         map.put(s, new HashSet<>());
         
        for(String w : wordSet){
             
            boolean diff=false;
            boolean add = true;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)!=w.charAt(i)){
                    if(diff==false){
                        diff=true;
                    }else{
                        add=false;
                        break;
                    }
                }
            }
            if(add)
                map.get(s).add(w);
         }
     }
    
//     private void findNeb(String s, List<String> wordList, HashMap<String, List<String>> map){
        
//         int[] arr = new int[26];
//         for(char ch : s.toCharArray()){
//             arr[ch-'a']++;
//         }
        
//         map.put(s, new ArrayList<>());
        
//         int[] tmp = new int[26];
//         for(String w : wordList){
            
//             System.arraycopy(arr, 0, tmp, 0, 26);
            
//             for(char ch : w.toCharArray()){
//                 tmp[ch-'a']--;
//             }
            
//             int diff=0;
//             for(int t : tmp){
//                 if(t>0)
//                     diff++;
//                 if(diff>2)
//                     continue;
//             }
            
//             if(diff<=2 && diff!=0)
//                 map.get(s).add(w);
//         }
        
//     }
}