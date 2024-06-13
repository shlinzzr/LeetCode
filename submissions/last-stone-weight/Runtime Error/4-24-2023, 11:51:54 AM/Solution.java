// https://leetcode.com/problems/last-stone-weight

class Solution {
    public int lastStoneWeight(int[] stones) {
        int len = stones.length;
        Arrays.sort(stones);
        List<Integer> list = new ArrayList<>();
        for(int s: stones){
            list.add(s);
        }
        
        while(list.size()>1){
            
            List<Integer> tmp = new ArrayList<>();
            
            int a = list.get(list.size()-1);
            int b = list.get(list.size()-2);
            
            list.remove(list.size()-1);
            list.remove(list.size()-1);
            
            int abs = Math.abs(a-b);
            if(abs!=0){
                list.add(abs);
            }
            
            Collections.sort(list);
        }
        
        return list.get(0);
        
        
    }
}