// https://leetcode.com/problems/largest-values-from-labels

class Solution {
    
    class Tuple{
        int val;
        int tag;
        
        public Tuple(int val, int tag){
            this.val=val;
            this.tag=tag;
        }
    }
    
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        
        Map<Integer, Integer> map = new HashMap<>(); // label, cnt
        
        int len = values.length;
        int score = 0;
        
        List<Tuple> list = new ArrayList<>();
        
        for(int i=0; i<len; i++){
            int v = values[i];
            int label = labels[i];
            
            Tuple t = new Tuple(v, label);
            list.add(t);
        }
        
        Collections.sort(list, (a,b)-> b.val-a.val);
        
        
        int cnt= 0;
        for(int i=0; i<list.size(); i++){
            
            Tuple t = list.get(i);
            if(map.getOrDefault(t.tag,0)<useLimit){
                score+=t.val;         
                cnt++;
                map.put(t.tag, map.getOrDefault(t.tag,0)+1);
            }
            
            if(cnt==numWanted) break;
        }
        
        return score;
    }
}