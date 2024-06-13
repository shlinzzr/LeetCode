// https://leetcode.com/problems/alien-dictionary

class Solution {
    public String alienOrder(String[] words) {
        
        if(words==null || words.length==0) 
            return "";

        HashMap<Character, Set<Character>> g = new HashMap<>();
        HashMap<Character, Integer> degree = new HashMap<>();

        for(String w : words){
            for(char ch : w.toCharArray()){
                degree.put(ch, 0);
            }
        }

        for(int i=0; i<words.length-1; i++){
            String curr = words[i];
            String next = words[i+1];

            int len = Math.min(curr.length(), next.length());

            if(curr.length()>next.length() && curr.substring(0, len).equals(next))
                return "";
            
            for(int j=0; j<len; j++){
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);

                if(c1!=c2){

                    Set<Character> set = g.getOrDefault(c1, new HashSet<>());
                    if(!set.contains(c2)){
                        set.add(c2);
                        g.put(c1, set);
                        degree.put(c2, degree.get(c2)+1);
                    }
                    // break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        for(char ch : degree.keySet()){
            if(degree.get(ch)==0)
                q.offer(ch);
        }

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){
            char ch = q.poll();
            sb.append(ch);

            Set<Character> set = g.getOrDefault(ch, new HashSet<>());
            for(char nxt : set){
                degree.put(nxt, degree.get(nxt)-1);
                if(degree.get(nxt)==0)
                    q.offer(nxt);
            }
        }

        return sb.toString();
    }
}