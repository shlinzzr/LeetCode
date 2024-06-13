// https://leetcode.com/problems/minimum-cost-to-convert-string-i

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        HashMap<Character, Map<Character, Long>> g = new HashMap<>();
        
        for(int i=0; i<original.length; i++){
            char org = original[i];
            char chg = changed[i];
            g.putIfAbsent(org, new HashMap<>());
            g.get(org).put(chg, Long.valueOf(cost[i]));
            // g.get(org).put(org, 0L);
        }
        
        long cnt =0;
        
        for(int i=0; i<source.length(); i++){
            
            char src = source.charAt(i);
            char tar = target.charAt(i);
            
            if(src==tar) continue;
            
            long val = helper(src, tar, g);
            // System.out.println(src + " " + tar + " "+val);
            if(val==-1) return -1;
            cnt += val;
        }
        
        return cnt;
        
    }
    
    private long helper(char src, char tar,  HashMap<Character, Map<Character, Long>> g){
        
        Queue<long[]> q= new LinkedList<>();
        HashMap<Character, Long> curMap = new HashMap<>();
        curMap.put(src, 0L);
        
        q.offer(new long[]{src-'a', 0L});// char, cost
        
         // System.out.println(q.size());
        
        while(!q.isEmpty()){
            long[] p = q.poll();
            char ch = (char)(p[0]+'a');
            long cost = p[1];
            
            // System.out.println(ch + " " + cost);
            
            if(g.containsKey(ch) && curMap.containsKey(ch)){
                
                Map<Character, Long> m = g.get(ch);
                for(Map.Entry<Character, Long> en : m.entrySet()){
                    
                    char next = en.getKey();
                    long val = en.getValue();
                    
                    if(!curMap.containsKey(next) || (curMap.containsKey(next) && curMap.get(next)>val+cost)){
                        curMap.put(next, (long)(val+cost));
                        q.offer(new long[]{ (long)(next-'a'), (long)(val+cost)});
                        
                    }
                    
                }
            }
        }
        
        return curMap.getOrDefault(tar, -1L);
        
        
    }
    
    
    
    /* public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src]=0;

        while(k-->=0){
            
            int[] tmp = Arrays.copyOfRange(cost, 0, n);
            
            for(int i=0; i<flights.length; i++){
                int from = flights[i][0];
                int to   = flights[i][1];
                int price = flights[i][2];

                if(cost[from]!=Integer.MAX_VALUE){
                    tmp[to] = Math.min(tmp[to] ,  cost[from] + price);
                }
            }

            cost = tmp;
        }

        return cost[dst]==Integer.MAX_VALUE ? -1 : cost[dst];
    }*/
}