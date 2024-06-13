// https://leetcode.com/problems/minimum-cost-to-convert-string-i

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] graph = new long[26][26];
        for(int i=0; i<26; i++){
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i]=0;
        }

        for(int i=0; i<original.length; i++){
            char src = original[i];
            char tar = changed[i];
            graph[src-'a'][tar-'a'] = Math.min(graph[src-'a'][tar-'a'], cost[i]);
        }

        for(int k=0; k<26; k++){
            for(int i=0; i<26; i++){
                if(graph[i][k]<Integer.MAX_VALUE){
                    for(int j=0; j<26; j++){
                
                        if(graph[k][j]<Integer.MAX_VALUE )
                            graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
                    }
                }
            }
        }

        long res = 0;
        for(int i=0; i<source.length(); i++){
            if(source.charAt(i)==target.charAt(i)) continue;
            
            long val = graph[source.charAt(i)-'a'][target.charAt(i)-'a'];
            if(val==Integer.MAX_VALUE) return -1L;
            res+=val;
                    
        }

        return res;

        
    }

}