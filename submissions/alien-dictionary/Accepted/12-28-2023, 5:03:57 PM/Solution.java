// https://leetcode.com/problems/alien-dictionary

class Solution {
    public String alienOrder(String[] words) {
        int len = words.length;
        Set<Character> set = new HashSet<>();
        for(String w : words){
            for(char ch : w.toCharArray()){
                set.add(ch);
            }
        }

        int n = set.size();
        int[] indeg = new int[26];


        Map<Character, Set<Character>> g = new HashMap<>();
        for(int i=0; i<len-1; i++){
            String a = words[i];
            String b = words[i+1];

            int min = Math.min(a.length(), b.length());

            if(a.length()>b.length() && a.substring(0, min).equals(b))
                return "";

            for(int j=0; j<min; j++){
                char cha = a.charAt(j);
                char chb = b.charAt(j);

                if(cha==chb) continue;

                //   Set<Character> adjs = g.getOrDefault(cha, new HashSet<>());
                //     if(!adjs.contains(chb)){
                //         adjs.add(chb);
                //         g.put(cha, adjs);
                //         indeg[chb-'a']++;
                //     }
                //     break;

                g.putIfAbsent(cha, new HashSet<>());
                if(!g.get(cha).contains(chb)){
                    g.get(cha).add(chb);
                    indeg[chb-'a']++;
                }
                break;

               

            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<26; i++){
            if(set.contains((char)(i+'a')) && indeg[i]==0){
                System.out.println(i);
                q.offer(i);
            }
        }

        // System.out.println(set.size() + " qs" +q.size());
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int siz = q.size();
            while(siz-->0){
                int p = q.poll();
                char ch = (char)(p+'a');

                sb.append(ch);

                for(char next : g.getOrDefault(ch, new HashSet<>())){
                    indeg[next-'a']--;

                    System.out.println(next + " de=" + indeg[next-'a']);
                    if(indeg[next-'a']==0)
                        q.offer(next-'a');
                }
            }
        }
        System.out.println(sb.toString()); 

        return sb.toString().length()==set.size() ? sb.toString() : "" ;
    }

}