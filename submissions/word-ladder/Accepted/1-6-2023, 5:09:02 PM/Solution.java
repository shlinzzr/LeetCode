// https://leetcode.com/problems/word-ladder

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(!wordList.contains(endWord))
            return 0;
        
        
        HashMap<String, List<String>> map = new HashMap<>();
        findNeb(beginWord, wordList, map);
        for(String w : wordList){
            findNeb(w, wordList, map);
        }
        
        for(Map.Entry<String, List<String>> en : map.entrySet()){
            System.out.println(en.getKey()+ " " + en.getValue());
        }
        
        
        
        HashSet<String> seen = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        seen.add(beginWord);
        int step=1;
        while(!q.isEmpty()){
            step++;
            
            for(int i=q.size(); i>0; i--){
                
                String p = q.poll();
                List<String> nebs = map.get(p);
                for(String n : nebs){
                    if(seen.contains(n))
                        continue;
                         
                    if(n.equals(endWord))
                        return step;
                    
                    seen.add(n);
                    q.offer(n);
                }
            }
            // System.out.println(step +" " + seen);
            
        }
        
        return 0;
        
        
    }
    
     private void findNeb(String s, List<String> wordList, HashMap<String, List<String>> map){
         map.put(s, new ArrayList<>());
         
        for(String w : wordList){
             
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